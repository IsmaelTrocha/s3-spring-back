package com.fullstack.s3.aplication.customer;

import com.fullstack.s3.domain.service.CustomerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProfileImageApplication {

  private final CustomerService customerService;


  public void updateProfileImage(Long customerId, String imageId) {
    customerService.updateCustomerProfileImageId(imageId, customerId);
  }
}
