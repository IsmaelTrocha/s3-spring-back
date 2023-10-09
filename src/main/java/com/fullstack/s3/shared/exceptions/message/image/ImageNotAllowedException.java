package com.fullstack.s3.shared.exceptions.message.image;

import com.fullstack.s3.shared.exceptions.base.BaseException;
import com.fullstack.s3.shared.exceptions.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ImageNotAllowedException extends BaseException {

  public ImageNotAllowedException(String message){
    super(false, HttpStatus.BAD_REQUEST,message, ExceptionCode.TEST);
  }
}
