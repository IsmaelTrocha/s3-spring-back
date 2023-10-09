package com.fullstack.s3.infrastructure.controller;

import com.fullstack.s3.aplication.customer.CreateCustomerApplication;
import com.fullstack.s3.aplication.customer.GetCustomerByIdApplication;
import com.fullstack.s3.infrastructure.adapter.CustomerServiceImpl;
import com.fullstack.s3.infrastructure.controller.dto.request.CustomerRequest;
import com.fullstack.s3.infrastructure.controller.dto.response.CustomerResponse;
import com.fullstack.s3.infrastructure.controller.dto.response.EntityResponse;
import com.fullstack.s3.infrastructure.controller.mapper.request.CustomerRequestMapper;
import com.fullstack.s3.infrastructure.controller.mapper.response.CustomerResponseMapper;
import com.fullstack.s3.shared.MessageUtils;
import com.fullstack.s3.shared.exceptions.code.MessageCode;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerServiceImpl customerService;
  private final GetCustomerByIdApplication getCustomerByIdApplication;
  private final CustomerResponseMapper customerResponseMapper;
  private final CreateCustomerApplication createCustomerApplication;
  private final CustomerRequestMapper customerRequestMapper;
  private final MessageUtils messageUtils;

  @PostMapping(path = "/create")
  public ResponseEntity<EntityResponse> createCustomer(
      @RequestBody CustomerRequest customerRequest) {
    createCustomerApplication.createCustomer(customerRequestMapper.toEntity(customerRequest));
    return new ResponseEntity<>(
        new EntityResponse(
            messageUtils.getMessage(String.valueOf(HttpStatus.CREATED.value())),
            messageUtils.getMessage(MessageCode.TEST.getCode()),
            messageUtils.getMessage( MessageCode.TEST.getType())),
        HttpStatus.CREATED);
  }

  @PostMapping(
      value = "/{customerId}/profile-image",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  public void uploadCustomerProfilePicture(
      @PathVariable("customerId") Long customerId,
      @RequestParam("file") MultipartFile file) {
    customerService.uploadCustomerProfilePicture(customerId, file);
  }

  @GetMapping(
      value = "/profile-image/{customerId}",
      produces = MediaType.IMAGE_JPEG_VALUE
  )
  public ResponseEntity<BufferedImage> getCustomerProfile(
      @PathVariable("customerId") Long customerId) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(
        customerService.getCustomerProfilePicture(customerId));
    return new ResponseEntity<>(ImageIO.read(bis), HttpStatus.OK);
  }

  @GetMapping(
      value = "/{customerId}"
  )
  public ResponseEntity<CustomerResponse> getCustomerById(
      @PathVariable("customerId") Long customerId) {
    return new ResponseEntity(
        customerResponseMapper.toDto(getCustomerByIdApplication.getCustomerById(customerId)),
        HttpStatus.FOUND);
  }
}
