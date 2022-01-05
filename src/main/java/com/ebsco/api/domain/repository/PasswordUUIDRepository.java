package com.ebsco.api.domain.repository;

import com.ebsco.data.entity.PasswordUUIDDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PasswordUUIDRepository extends JpaRepository<PasswordUUIDDetails, String> {

  @Query(value = "select * from password_details where id=?1", nativeQuery = true)
  PasswordUUIDDetails findByUUID(String id);

  @Query(value = "select email from password_details where id=?1", nativeQuery = true)
  String findEmailByID(String id);


}
