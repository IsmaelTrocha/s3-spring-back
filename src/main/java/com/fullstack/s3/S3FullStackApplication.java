package com.fullstack.s3;

import com.fullstack.s3.domain.service.S3Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S3FullStackApplication {

  public static void main(String[] args) {

    SpringApplication.run(S3FullStackApplication.class, args);

  }

}
