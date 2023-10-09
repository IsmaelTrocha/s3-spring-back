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

  @Bean
  CommandLineRunner runner(S3Service s3Service) {
    return args -> {
      s3Service.putObject(
          "spring-full-stack",
          "foo",
          "Hello Wolrd".getBytes());
      System.out.println("Hello world");
    };

  }

}