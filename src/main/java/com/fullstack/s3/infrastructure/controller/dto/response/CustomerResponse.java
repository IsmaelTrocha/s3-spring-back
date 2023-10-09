package com.fullstack.s3.infrastructure.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String profileImageId;
  private int age;
  private boolean status;

}
