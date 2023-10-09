package com.fullstack.s3.shared.exceptions.message.customer;

import com.fullstack.s3.shared.exceptions.base.BaseException;
import com.fullstack.s3.shared.exceptions.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends BaseException {

  public CustomerNotFoundException(String message) {
    super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.CUSTOMER_NOT_FOUND);
  }

}
