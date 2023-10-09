package com.fullstack.s3.shared.exceptions.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ErrorResponse {

  private int status;
  private String code;
  private String message;
  private String date;
}