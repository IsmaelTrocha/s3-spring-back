package com.fullstack.s3.aplication;

import com.fullstack.s3.aplication.customer.CreateCustomerApplication;
import com.fullstack.s3.aplication.customer.GetCustomerByIdApplication;
import com.fullstack.s3.aplication.customer.UpdateProfileImageApplication;
import com.fullstack.s3.aplication.s3.process.ImageValidations;
import com.fullstack.s3.domain.service.CustomerService;
import com.fullstack.s3.shared.MessageUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanModuleApplication {

  @Bean
  public GetCustomerByIdApplication getCustomerByIdApplication(
      CustomerService customerService
  ) {
    return new GetCustomerByIdApplication(customerService);
  }

  @Bean
  public UpdateProfileImageApplication updateProfileImageApplication(
      CustomerService customerService
  ) {
    return new UpdateProfileImageApplication(customerService);
  }

  @Bean
  public CreateCustomerApplication createCustomerApplication(
      CustomerService customerService
  ) {
    return new CreateCustomerApplication(customerService);
  }

  @Bean
  public ImageValidations imageValidations(MessageUtils messageUtils) {
    return new ImageValidations(messageUtils);
  }

}
