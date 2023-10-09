package com.fullstack.s3.infrastructure.adapter;

import com.fullstack.s3.config.S3Bucket;
import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.domain.service.CustomerService;
import com.fullstack.s3.domain.service.S3Service;
import com.fullstack.s3.infrastructure.mapper.CustomerDtoMapper;
import com.fullstack.s3.infrastructure.repository.CustomerRepository;
import com.fullstack.s3.shared.MessageUtils;
import com.fullstack.s3.shared.exceptions.code.ExceptionCode;
import com.fullstack.s3.shared.exceptions.message.customer.ProfileImageNotFoundException;
import com.fullstack.s3.shared.exceptions.message.image.ImageNotAllowedException;
import com.fullstack.s3.shared.exceptions.message.image.ImageOutOfBoundsException;
import com.fullstack.s3.shared.exceptions.message.image.ImageRequiredException;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private static final long MAX_FILE_SIZE = 6 * 1024 * 1024;
  private final S3Service s3Service;
  private final S3Bucket s3Bucket;
  private final CustomerRepository customerRepository;
  private final CustomerDtoMapper customerDtoMapper;
  private final MessageUtils messageUtils;


  public Customer createCustomer(Customer customer) {
    return customerDtoMapper.toEntity(customerRepository.save(customerDtoMapper.toDto(customer)));
  }


  public void uploadCustomerProfilePicture(Long customerId, MultipartFile file) {
    String profileImgId = UUID.randomUUID().toString();

    try {
      s3Service.putObject(s3Bucket.getBucket(),
          "profile-images/%s/%s".formatted(customerId, profileImgId),
          file.getBytes()
      );

    } catch (IOException exception) {
      throw new IllegalStateException(exception);
    }
    customerRepository.updateCustomerProfileImageId(customerId, profileImgId);
  }

  public byte[] getCustomerProfilePicture(Long customerId) {

    var customer = findByCustomerById(customerId);

    if (customer.getProfileImageId().isBlank()) {
      throw new ProfileImageNotFoundException(
          messageUtils.getMessage(ExceptionCode.CUSTOMER_NOT_FOUND.getType(),
              customerId.toString()));
    }

    return s3Service.getObject(
        s3Bucket.getBucket(),
        "profile-images/%s/%s".formatted(customerId, customer.getProfileImageId())
    );

  }


  @Override
  public Customer findByCustomerById(Long customerId) {
    return customerDtoMapper.toEntity(customerRepository.findById(customerId)
        .orElseThrow(() -> new RuntimeException("Customer was not found")));
  }

  @Override
  public void updateCustomerProfileImageId(String imageProfileId, Long customerId) {
    customerRepository.updateCustomerProfileImageId(customerId, imageProfileId);
  }




}
