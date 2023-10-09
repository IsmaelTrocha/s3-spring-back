package com.fullstack.s3.infrastructure.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, Long> {


  @Modifying
  @Transactional
  @Query(value = "UPDATE CustomerDto c SET c.profileImageId = ?2 WHERE c.id= ?1")
  void updateCustomerProfileImageId(Long customerId, String imageId);
}
