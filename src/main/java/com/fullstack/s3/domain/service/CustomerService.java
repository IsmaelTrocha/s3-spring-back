package com.fullstack.s3.domain.service;

import com.fullstack.s3.domain.entities.Customer;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerService {

  Customer findByCustomerById(Long customerId);

  Customer createCustomer(Customer customer);

  void updateCustomerProfileImageId(String imageProfileId, Long customerId);
  void uploadCustomerProfilePicture(Long customerId, MultipartFile file);
}
