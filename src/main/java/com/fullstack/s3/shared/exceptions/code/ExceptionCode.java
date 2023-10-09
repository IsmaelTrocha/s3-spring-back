package com.fullstack.s3.shared.exceptions.code;

import lombok.Getter;

@Getter
public enum ExceptionCode {

  TEST("", ""),
  CUSTOMER_EMAIL_ALREADY_EXISTS("ERR-01","Exception.CUSTOMER_EMAIL_ALREADY_EXISTS"),
  CUSTOMER_NOT_FOUND("ERR-02","Exception.CUSTOMER_NOT_FOUND"),
  IMAGE_REQUIRED("ERR-03","Exception.IMAGE_REQUIRED"),
  IMAGE_NOT_ALLOWED("ERR-04","Exception.IMAGE_REQUIRED"),
  IMAGE_OUT_BOUNDS( "ERR-05","Exception.IMAGE_OUT_OF_BOUNDS");

  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }
}