package com.fullstack.s3.infrastructure.controller.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

  private String name;
  private String email;
  private String password;
  private String phone;
  private String profileImageId;
  private int age;
}
