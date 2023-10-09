package com.fullstack.s3.aplication.customer;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.domain.service.CustomerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCustomerApplication {

  private final CustomerService customerService;

  public Customer createCustomer(Customer customer){
    customer.setStatus(false);
    return customerService.createCustomer(customer);
  }
}
