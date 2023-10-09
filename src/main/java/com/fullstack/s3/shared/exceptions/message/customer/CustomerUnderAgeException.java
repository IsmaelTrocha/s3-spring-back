package com.fullstack.s3.shared.exceptions.message.customer;

import com.fullstack.s3.shared.exceptions.base.BaseException;
import com.fullstack.s3.shared.exceptions.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CustomerUnderAgeException extends BaseException {

  public CustomerUnderAgeException(String message){
    super(false, HttpStatus.BAD_REQUEST,message, ExceptionCode.TEST);
  }

}
