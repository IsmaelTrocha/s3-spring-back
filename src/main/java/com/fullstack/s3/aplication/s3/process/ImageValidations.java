package com.fullstack.s3.aplication.s3.process;


import com.fullstack.s3.shared.MessageUtils;
import com.fullstack.s3.shared.exceptions.code.ExceptionCode;
import com.fullstack.s3.shared.exceptions.message.image.ImageNotAllowedException;
import com.fullstack.s3.shared.exceptions.message.image.ImageOutOfBoundsException;
import com.fullstack.s3.shared.exceptions.message.image.ImageRequiredException;
import org.springframework.web.multipart.MultipartFile;

public class ImageValidations {

  public static final int MAX_FILE_SIZE = 6 * 1024 * 1024;
  private MessageUtils messageUtils;

  private void imageValidations(MultipartFile file) {
    imageOutOfBounds(file);
    validateImgName(file);
    imageRequired(file);
  }

  private void imageOutOfBounds(MultipartFile file) {
    if (file.getSize() > MAX_FILE_SIZE) {
      throw new ImageOutOfBoundsException(
          messageUtils.getMessage(ExceptionCode.IMAGE_OUT_BOUNDS.getType(),
              String.valueOf(file.getSize())));
    }
  }

  private void validateImgName(MultipartFile file) {
    if (!file.getName().endsWith("png") || !file.getName().endsWith("jpg") || !file.getName()
        .endsWith("jpeg")) {
      throw new ImageNotAllowedException(
          messageUtils.getMessage(ExceptionCode.IMAGE_NOT_ALLOWED.getType(),
              String.valueOf(file.getSize())));
    }
  }

  private void imageRequired(MultipartFile file) {
    if (file.getName().isBlank() || file.getName().isEmpty()) {
      throw new ImageRequiredException(
          messageUtils.getMessage(ExceptionCode.IMAGE_REQUIRED.getType()));
    }
  }
}
