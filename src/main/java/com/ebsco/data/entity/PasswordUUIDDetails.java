package com.ebsco.data.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "passwordDetails")
public class PasswordUUIDDetails {

  @Id
  private Integer id;
  @Column(name = "username")
  @Size(min = 3, max = 100)
  @NotNull(message = "userName required but found null")
  @NotBlank(message = "userName required but found blank")
  @NotEmpty(message = "userName required but found empty")
  private String userName;
  @Column(name = "userid")
  @NotNull(message = "userId required but found null")
  private Integer userId;

  @Column(name = "createdtime")
  private LocalDateTime createdTime;
  @NotNull(message = "email required but found null")
  @NotBlank(message = "email required but found blank")
  @NotEmpty(message = "email required but found empty")
  private String email;


  public PasswordUUIDDetails(Integer id,
    @Size(min = 3, max = 100) @NotNull(message = "userName required but found null") @NotBlank(message = "userName required but found blank") @NotEmpty(message = "userName required but found empty") String userName,
    @NotNull(message = "userId required but found null") Integer userId,
    LocalDateTime createdTime,
    @NotNull(message = "email required but found null") @NotBlank(message = "email required but found blank") @NotEmpty(message = "email required but found empty") String email) {
    this.id = id;
    this.userName = userName;
    this.userId = userId;
    this.createdTime = createdTime;
    this.email = email;
  }

  public PasswordUUIDDetails() {
  }

  public static PasswordUUIDDetailsBuilder builder() {
    return new PasswordUUIDDetailsBuilder();
  }

  public Integer getId() {
    return this.id;
  }

  public @Size(min = 3, max = 100) @NotNull(message = "userName required but found null") @NotBlank(message = "userName required but found blank") @NotEmpty(message = "userName required but found empty") String getUserName() {
    return this.userName;
  }

  public @NotNull(message = "userId required but found null") Integer getUserId() {
    return this.userId;
  }

  public LocalDateTime getCreatedTime() {
    return this.createdTime;
  }

  public @NotNull(message = "email required but found null") @NotBlank(message = "email required but found blank") @NotEmpty(message = "email required but found empty") String getEmail() {
    return this.email;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUserName(
    @Size(min = 3, max = 100) @NotNull(message = "userName required but found null") @NotBlank(message = "userName required but found blank") @NotEmpty(message = "userName required but found empty") String userName) {
    this.userName = userName;
  }

  public void setUserId(@NotNull(message = "userId required but found null") Integer userId) {
    this.userId = userId;
  }

  public void setCreatedTime(LocalDateTime createdTime) {
    this.createdTime = createdTime;
  }

  public void setEmail(
    @NotNull(message = "email required but found null") @NotBlank(message = "email required but found blank") @NotEmpty(message = "email required but found empty") String email) {
    this.email = email;
  }

  public String toString() {
    return "PasswordUUIDDetails(id=" + this.getId() + ", userName=" + this.getUserName()
      + ", userId=" + this.getUserId() + ", createdTime=" + this.getCreatedTime() + ", email="
      + this.getEmail() + ")";
  }

  public static class PasswordUUIDDetailsBuilder {

    private Integer id;
    private @Size(min = 3, max = 100) @NotNull(message = "userName required but found null") @NotBlank(message = "userName required but found blank") @NotEmpty(message = "userName required but found empty") String userName;
    private @NotNull(message = "userId required but found null") Integer userId;
    private LocalDateTime createdTime;
    private @NotNull(message = "email required but found null") @NotBlank(message = "email required but found blank") @NotEmpty(message = "email required but found empty") String email;

    PasswordUUIDDetailsBuilder() {
    }

    public PasswordUUIDDetailsBuilder id(Integer id) {
      this.id = id;
      return this;
    }

    public PasswordUUIDDetailsBuilder userName(
      @Size(min = 3, max = 100) @NotNull(message = "userName required but found null") @NotBlank(message = "userName required but found blank") @NotEmpty(message = "userName required but found empty") String userName) {
      this.userName = userName;
      return this;
    }

    public PasswordUUIDDetailsBuilder userId(
      @NotNull(message = "userId required but found null") Integer userId) {
      this.userId = userId;
      return this;
    }

    public PasswordUUIDDetailsBuilder createdTime(LocalDateTime createdTime) {
      this.createdTime = createdTime;
      return this;
    }

    public PasswordUUIDDetailsBuilder email(
      @NotNull(message = "email required but found null") @NotBlank(message = "email required but found blank") @NotEmpty(message = "email required but found empty") String email) {
      this.email = email;
      return this;
    }

    public PasswordUUIDDetails build() {
      return new PasswordUUIDDetails(id, userName, userId, createdTime, email);
    }

    public String toString() {
      return "PasswordUUIDDetails.PasswordUUIDDetailsBuilder(id=" + this.id + ", userName="
        + this.userName + ", userId=" + this.userId + ", createdTime=" + this.createdTime
        + ", email=" + this.email + ")";
    }
  }
}
