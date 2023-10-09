package com.fullstack.s3.aplication.customer;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.domain.service.CustomerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCustomerByIdApplication {

  private final CustomerService customerService;

  public Customer getCustomerById(Long customerId) {
    return customerService.findByCustomerById(customerId);
  }
}
