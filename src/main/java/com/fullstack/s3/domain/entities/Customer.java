package com.fullstack.s3.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  private Long id;
  private String name;
  private String email;
  private String password;
  private String phone;
  private String profileImageId;
  private int age;
  private boolean status;

}
