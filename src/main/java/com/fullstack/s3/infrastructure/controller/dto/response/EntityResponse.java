package com.fullstack.s3.infrastructure.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityResponse {

  private String status;
  private String code;
  private String message;
}
