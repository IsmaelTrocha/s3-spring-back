package com.fullstack.s3.shared.exceptions.message.customer;

import com.fullstack.s3.shared.exceptions.base.BaseException;
import com.fullstack.s3.shared.exceptions.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ProfileImageNotFoundException extends BaseException {

  public ProfileImageNotFoundException(String message){
    super(false, HttpStatus.NOT_FOUND,message, ExceptionCode.TEST);
  }
}
