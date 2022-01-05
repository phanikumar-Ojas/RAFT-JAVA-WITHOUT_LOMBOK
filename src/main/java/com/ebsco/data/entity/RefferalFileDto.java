package com.ebsco.data.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefferalFileDto {

  @JsonProperty("id")
  private Long id;

  // FILE_TYPE
  @JsonProperty("fileType")
  private String fileType;

  // ORT_BYTE_SIZE
  @JsonProperty("ortByteSize")
  private String ortByteSize;

  // FILE_NAME
  @JsonProperty("fileName")
  private String fileName;

  //FILE_CONTENTS
  @JsonProperty("fileContents")
  private String fileContents;

  // SENDER_NAME
  @JsonProperty("senderName")
  private String senderName;

  // PICK_IND
  @JsonProperty("pickInd")
  private String pickInd;

  //CREATE_TS
  @JsonProperty("createTs")
  private Timestamp createTs = null;

  //UPDATE_TS
  @JsonProperty("updateTs")
  private Timestamp updateTs = null;

  // CREATE_USER_NM
  @JsonProperty("createUserNm")
  private String createUserNm;

  // UPDATE_USER_NM
  @JsonProperty("updateUserNm")
  private String updateUserNm;


  // REFERRAL_LOAD_TXN_ID
  @JsonProperty("referralLoadTxnId")
  private Long referralLoadTxnId;

  // TOTAL_RECORD_COUNT
  @JsonProperty("totalRecordCount")
  private Integer totalRecordCount;


  // RECORDS_PROCESSED
  @JsonProperty("recordsProcessed")
  private Integer recordsProcessed;

  // FILE_LOAD_ID
  @JsonProperty("fileLoadId")
  private Long fileLoadId;


  public RefferalFileDto(Long id, String fileType, String ortByteSize, String fileName,
    String fileContents, String senderName, String pickInd, Timestamp createTs,
    Timestamp updateTs, String createUserNm, String updateUserNm, Long referralLoadTxnId,
    Integer totalRecordCount, Integer recordsProcessed, Long fileLoadId) {
    this.id = id;
    this.fileType = fileType;
    this.ortByteSize = ortByteSize;
    this.fileName = fileName;
    this.fileContents = fileContents;
    this.senderName = senderName;
    this.pickInd = pickInd;
    this.createTs = createTs;
    this.updateTs = updateTs;
    this.createUserNm = createUserNm;
    this.updateUserNm = updateUserNm;
    this.referralLoadTxnId = referralLoadTxnId;
    this.totalRecordCount = totalRecordCount;
    this.recordsProcessed = recordsProcessed;
    this.fileLoadId = fileLoadId;
  }

  public RefferalFileDto() {
  }

  public static RefferalFileDtoBuilder builder() {
    return new RefferalFileDtoBuilder();
  }

  public Long getId() {
    return this.id;
  }

  public String getFileType() {
    return this.fileType;
  }

  public String getOrtByteSize() {
    return this.ortByteSize;
  }

  public String getFileName() {
    return this.fileName;
  }

  public String getFileContents() {
    return this.fileContents;
  }

  public String getSenderName() {
    return this.senderName;
  }

  public String getPickInd() {
    return this.pickInd;
  }

  public Timestamp getCreateTs() {
    return this.createTs;
  }

  public Timestamp getUpdateTs() {
    return this.updateTs;
  }

  public String getCreateUserNm() {
    return this.createUserNm;
  }

  public String getUpdateUserNm() {
    return this.updateUserNm;
  }

  public Long getReferralLoadTxnId() {
    return this.referralLoadTxnId;
  }

  public Integer getTotalRecordCount() {
    return this.totalRecordCount;
  }

  public Integer getRecordsProcessed() {
    return this.recordsProcessed;
  }

  public Long getFileLoadId() {
    return this.fileLoadId;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  @JsonProperty("fileType")
  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  @JsonProperty("ortByteSize")
  public void setOrtByteSize(String ortByteSize) {
    this.ortByteSize = ortByteSize;
  }

  @JsonProperty("fileName")
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @JsonProperty("fileContents")
  public void setFileContents(String fileContents) {
    this.fileContents = fileContents;
  }

  @JsonProperty("senderName")
  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  @JsonProperty("pickInd")
  public void setPickInd(String pickInd) {
    this.pickInd = pickInd;
  }

  @JsonProperty("createTs")
  public void setCreateTs(Timestamp createTs) {
    this.createTs = createTs;
  }

  @JsonProperty("updateTs")
  public void setUpdateTs(Timestamp updateTs) {
    this.updateTs = updateTs;
  }

  @JsonProperty("createUserNm")
  public void setCreateUserNm(String createUserNm) {
    this.createUserNm = createUserNm;
  }

  @JsonProperty("updateUserNm")
  public void setUpdateUserNm(String updateUserNm) {
    this.updateUserNm = updateUserNm;
  }

  @JsonProperty("referralLoadTxnId")
  public void setReferralLoadTxnId(Long referralLoadTxnId) {
    this.referralLoadTxnId = referralLoadTxnId;
  }

  @JsonProperty("totalRecordCount")
  public void setTotalRecordCount(Integer totalRecordCount) {
    this.totalRecordCount = totalRecordCount;
  }

  @JsonProperty("recordsProcessed")
  public void setRecordsProcessed(Integer recordsProcessed) {
    this.recordsProcessed = recordsProcessed;
  }

  @JsonProperty("fileLoadId")
  public void setFileLoadId(Long fileLoadId) {
    this.fileLoadId = fileLoadId;
  }

  public String toString() {
    return "RefferalFileDto(id=" + this.getId() + ", fileType=" + this.getFileType()
      + ", ortByteSize=" + this.getOrtByteSize() + ", fileName=" + this.getFileName()
      + ", fileContents=" + this.getFileContents() + ", senderName=" + this.getSenderName()
      + ", pickInd=" + this.getPickInd() + ", createTs=" + this.getCreateTs() + ", updateTs="
      + this.getUpdateTs() + ", createUserNm=" + this.getCreateUserNm() + ", updateUserNm="
      + this.getUpdateUserNm() + ", referralLoadTxnId=" + this.getReferralLoadTxnId()
      + ", totalRecordCount=" + this.getTotalRecordCount() + ", recordsProcessed="
      + this.getRecordsProcessed() + ", fileLoadId=" + this.getFileLoadId() + ")";
  }

  public static class RefferalFileDtoBuilder {

    private Long id;
    private String fileType;
    private String ortByteSize;
    private String fileName;
    private String fileContents;
    private String senderName;
    private String pickInd;
    private Timestamp createTs;
    private Timestamp updateTs;
    private String createUserNm;
    private String updateUserNm;
    private Long referralLoadTxnId;
    private Integer totalRecordCount;
    private Integer recordsProcessed;
    private Long fileLoadId;

    RefferalFileDtoBuilder() {
    }

    public RefferalFileDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public RefferalFileDtoBuilder fileType(String fileType) {
      this.fileType = fileType;
      return this;
    }

    public RefferalFileDtoBuilder ortByteSize(String ortByteSize) {
      this.ortByteSize = ortByteSize;
      return this;
    }

    public RefferalFileDtoBuilder fileName(String fileName) {
      this.fileName = fileName;
      return this;
    }

    public RefferalFileDtoBuilder fileContents(String fileContents) {
      this.fileContents = fileContents;
      return this;
    }

    public RefferalFileDtoBuilder senderName(String senderName) {
      this.senderName = senderName;
      return this;
    }

    public RefferalFileDtoBuilder pickInd(String pickInd) {
      this.pickInd = pickInd;
      return this;
    }

    public RefferalFileDtoBuilder createTs(Timestamp createTs) {
      this.createTs = createTs;
      return this;
    }

    public RefferalFileDtoBuilder updateTs(Timestamp updateTs) {
      this.updateTs = updateTs;
      return this;
    }

    public RefferalFileDtoBuilder createUserNm(String createUserNm) {
      this.createUserNm = createUserNm;
      return this;
    }

    public RefferalFileDtoBuilder updateUserNm(String updateUserNm) {
      this.updateUserNm = updateUserNm;
      return this;
    }

    public RefferalFileDtoBuilder referralLoadTxnId(Long referralLoadTxnId) {
      this.referralLoadTxnId = referralLoadTxnId;
      return this;
    }

    public RefferalFileDtoBuilder totalRecordCount(Integer totalRecordCount) {
      this.totalRecordCount = totalRecordCount;
      return this;
    }

    public RefferalFileDtoBuilder recordsProcessed(Integer recordsProcessed) {
      this.recordsProcessed = recordsProcessed;
      return this;
    }

    public RefferalFileDtoBuilder fileLoadId(Long fileLoadId) {
      this.fileLoadId = fileLoadId;
      return this;
    }

    public RefferalFileDto build() {
      return new RefferalFileDto(id, fileType, ortByteSize, fileName, fileContents, senderName,
        pickInd, createTs, updateTs, createUserNm, updateUserNm, referralLoadTxnId,
        totalRecordCount, recordsProcessed, fileLoadId);
    }

    public String toString() {
      return "RefferalFileDto.RefferalFileDtoBuilder(id=" + this.id + ", fileType=" + this.fileType
        + ", ortByteSize=" + this.ortByteSize + ", fileName=" + this.fileName + ", fileContents="
        + this.fileContents + ", senderName=" + this.senderName + ", pickInd=" + this.pickInd
        + ", createTs=" + this.createTs + ", updateTs=" + this.updateTs + ", createUserNm="
        + this.createUserNm + ", updateUserNm=" + this.updateUserNm + ", referralLoadTxnId="
        + this.referralLoadTxnId + ", totalRecordCount=" + this.totalRecordCount
        + ", recordsProcessed=" + this.recordsProcessed + ", fileLoadId=" + this.fileLoadId + ")";
    }
  }
}
