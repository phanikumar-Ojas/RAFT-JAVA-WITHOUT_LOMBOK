package com.ebsco.data.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import org.springframework.web.multipart.MultipartFile;

public class RefferalsDto implements Serializable {

  private Long id;

  private String fileType;

  private String ortByteSize;

  private MultipartFile file;
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

  public RefferalsDto() {
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

  public MultipartFile getFile() {
    return this.file;
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

  public void setId(Long id) {
    this.id = id;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public void setOrtByteSize(String ortByteSize) {
    this.ortByteSize = ortByteSize;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  public void setPickInd(String pickInd) {
    this.pickInd = pickInd;
  }

  public void setCreateTs(Timestamp createTs) {
    this.createTs = createTs;
  }

  public void setUpdateTs(Timestamp updateTs) {
    this.updateTs = updateTs;
  }

  public void setCreateUserNm(String createUserNm) {
    this.createUserNm = createUserNm;
  }

  public void setUpdateUserNm(String updateUserNm) {
    this.updateUserNm = updateUserNm;
  }

  public void setReferralLoadTxnId(Long referralLoadTxnId) {
    this.referralLoadTxnId = referralLoadTxnId;
  }

  public void setTotalRecordCount(Integer totalRecordCount) {
    this.totalRecordCount = totalRecordCount;
  }

  public void setRecordsProcessed(Integer recordsProcessed) {
    this.recordsProcessed = recordsProcessed;
  }

  public void setFileLoadId(Long fileLoadId) {
    this.fileLoadId = fileLoadId;
  }

  public String toString() {
    return "RefferalsDto(id=" + this.getId() + ", fileType=" + this.getFileType() + ", ortByteSize="
      + this.getOrtByteSize() + ", file=" + this.getFile() + ", senderName="
      + this.getSenderName() + ", pickInd=" + this.getPickInd() + ", createTs="
      + this.getCreateTs() + ", updateTs=" + this.getUpdateTs() + ", createUserNm="
      + this.getCreateUserNm() + ", updateUserNm=" + this.getUpdateUserNm()
      + ", referralLoadTxnId=" + this.getReferralLoadTxnId() + ", totalRecordCount="
      + this.getTotalRecordCount() + ", recordsProcessed=" + this.getRecordsProcessed()
      + ", fileLoadId=" + this.getFileLoadId() + ")";
  }
}
