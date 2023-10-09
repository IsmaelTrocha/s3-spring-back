package com.fullstack.s3.shared.exceptions.code;

import lombok.Getter;

@Getter
public enum MessageCode {

  TEST("", "");

  private final String type;
  private final String code;


  MessageCode(String type, String code) {
    this.type = type;
    this.code = code;
  }

}


