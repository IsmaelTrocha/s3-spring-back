package com.fullstack.s3.infrastructure.adapter;

import com.fullstack.s3.domain.service.S3Service;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

  private final S3Client s3Client;

  @Override
  public void putObject(String bucketName, String key, byte[] file) {
    PutObjectRequest objectRequest = PutObjectRequest
        .builder()
        .bucket(bucketName)
        .key(key)
        .build();

    s3Client.putObject(objectRequest, RequestBody.fromBytes(file));
  }

  @Override
  public byte[] getObject(String bucketName, String key) {
    GetObjectRequest getObjectRequest = GetObjectRequest.builder()
        .bucket(bucketName)
        .key(key).build();

    ResponseInputStream<GetObjectResponse> res = s3Client.getObject(getObjectRequest);

    try {

      return res.readAllBytes();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void deleteObject(String bucketName, String key) {
    DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest
        .builder()
        .bucket(bucketName)
        .key(key)
        .build();
    s3Client.deleteObject(deleteObjectRequest);
  }
}
