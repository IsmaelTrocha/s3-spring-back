package com.fullstack.s3.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class S3Bucket {

  @Value("${aws.s3.buckets.customer}")
  private String bucket;

}
