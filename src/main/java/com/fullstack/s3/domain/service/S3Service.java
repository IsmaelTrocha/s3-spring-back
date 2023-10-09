package com.fullstack.s3.domain.service;


public interface S3Service {

  void putObject(String bucketName, String key, byte[] file);

  byte[] getObject(String bucketName, String key);

}
