package com.ebsco.api.domain.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ebsco.data.entity.UserDetails;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

  public Optional<UserDetails> findByEmpId(String userName);

  @Query(value = "select * from userdetails where empId=?1 and  BINARY password like ?2", nativeQuery = true)
  public Optional<UserDetails> findByUserNameAndPassword(String userName, String password);

  @Query(value = "select costcenter from userdetails where empid=?1", nativeQuery = true)
  public String findCostCenterByPMId(String empId);

  @Query(value = "select * from userdetails where email= :email", nativeQuery = true)
  public UserDetails findByEmail(@NotNull @Param("email") String email);


  @Query(value = "select * from userdetails "
    + "where CASE WHEN :empId IS NOT NULL THEN EMPID= :empId ELSE empId LIKE '%' OR empId IS NULL END AND "
    + " CASE WHEN :empName IS NOT NULL THEN EMPName= :empName ELSE empName LIKE '%' OR empName IS NULL END AND  "
    + " CASE WHEN :costCenter IS NOT NULL THEN costcenter= :costCenter ELSE costcenter LIKE '%' OR costcenter IS NULL END  AND "
    + " CASE WHEN :emailId IS NOT NULL THEN EMAIL= :emailId ELSE EMAIL LIKE '%' OR EMAIL IS NULL END AND  "
    + " CASE WHEN :actualPageSize IS NOT NULL AND :pageSize IS NOT NULL THEN limit :actualPageSize , :pageSize  ELSE limit ALL END", nativeQuery = true)
  public List<UserDetails> findAll(@Param("actualPageSize") @Nullable Integer actualPageSize,
    @Param("pageSize") @Nullable Integer pageSize,
    @Param("empId") @Nullable String empId, @Param("empName") @Nullable String empName,
    @Param("costCenter") @Nullable String costCenter,
    @Param("emailId") @Nullable String emailId);

  @Query(value = "select * from userdetails "
    + "where CASE WHEN :empId IS NOT NULL THEN EMPID= :empId ELSE empId LIKE '%' OR empId IS NULL END AND "
    + " CASE WHEN :empName IS NOT NULL THEN EMPName= :empName ELSE empName LIKE '%' OR empName IS NULL END AND  "
    + " CASE WHEN :costCenter IS NOT NULL THEN costcenter= :costCenter ELSE costcenter LIKE '%' OR costcenter IS NULL END  AND "
    + " CASE WHEN :emailId IS NOT NULL THEN EMAIL= :emailId ELSE EMAIL LIKE '%' OR EMAIL IS NULL END ", nativeQuery = true)
  public List<UserDetails> findAllWithOutPagination(
    @Param("empId") @Nullable String empId, @Param("empName") @Nullable String empName,
    @Param("costCenter") @Nullable String costCenter,
    @Param("emailId") @Nullable String emailId);

  @Query(value = "select count(*) from userdetails", nativeQuery = true)
  public int getAllUsersCount();

  @Modifying
  @Query(value = "update userdetails set password= :password where empId= :userName AND userid= :id ", nativeQuery = true)
  public int updateUserPassword(@Param("userName") String userName, @Param("id") Integer id,
    @Param("password") String password);


}
