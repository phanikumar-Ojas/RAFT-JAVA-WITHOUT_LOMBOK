package com.ebsco.data.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PmIdFileDetailsDto {

  private Long fileID;

  private Long requestID;

  private String pmId;

  private String fileName;
  private String fileSize;

  private Timestamp uploadedDate;

  private String type;

  private String contentType;

  private String deletedBy;

  private LocalDateTime deletedDate;

  private Boolean isDeleted;

  public PmIdFileDetailsDto(Long fileID, Long requestID, String pmId, String fileName,
    String fileSize, Timestamp uploadedDate, String type, String contentType, String deletedBy,
    LocalDateTime deletedDate, Boolean isDeleted) {
    this.fileID = fileID;
    this.requestID = requestID;
    this.pmId = pmId;
    this.fileName = fileName;
    this.fileSize = fileSize;
    this.uploadedDate = uploadedDate;
    this.type = type;
    this.contentType = contentType;
    this.deletedBy = deletedBy;
    this.deletedDate = deletedDate;
    this.isDeleted = isDeleted;
  }

  public PmIdFileDetailsDto() {
  }

  public static PmIdFileDetailsDtoBuilder builder() {
    return new PmIdFileDetailsDtoBuilder();
  }

  public Long getFileID() {
    return this.fileID;
  }

  public Long getRequestID() {
    return this.requestID;
  }

  public String getPmId() {
    return this.pmId;
  }

  public String getFileName() {
    return this.fileName;
  }

  public String getFileSize() {
    return this.fileSize;
  }

  public Timestamp getUploadedDate() {
    return this.uploadedDate;
  }

  public String getType() {
    return this.type;
  }

  public String getContentType() {
    return this.contentType;
  }

  public String getDeletedBy() {
    return this.deletedBy;
  }

  public LocalDateTime getDeletedDate() {
    return this.deletedDate;
  }

  public Boolean getIsDeleted() {
    return this.isDeleted;
  }

  public void setFileID(Long fileID) {
    this.fileID = fileID;
  }

  public void setRequestID(Long requestID) {
    this.requestID = requestID;
  }

  public void setPmId(String pmId) {
    this.pmId = pmId;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public void setFileSize(String fileSize) {
    this.fileSize = fileSize;
  }

  public void setUploadedDate(Timestamp uploadedDate) {
    this.uploadedDate = uploadedDate;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public void setDeletedBy(String deletedBy) {
    this.deletedBy = deletedBy;
  }

  public void setDeletedDate(LocalDateTime deletedDate) {
    this.deletedDate = deletedDate;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public String toString() {
    return "PmIdFileDetailsDto(fileID=" + this.getFileID() + ", requestID=" + this.getRequestID()
      + ", pmId=" + this.getPmId() + ", fileName=" + this.getFileName() + ", fileSize="
      + this.getFileSize() + ", uploadedDate=" + this.getUploadedDate() + ", type="
      + this.getType() + ", contentType=" + this.getContentType() + ", deletedBy="
      + this.getDeletedBy() + ", deletedDate=" + this.getDeletedDate() + ", isDeleted="
      + this.getIsDeleted() + ")";
  }

  public static class PmIdFileDetailsDtoBuilder {

    private Long fileID;
    private Long requestID;
    private String pmId;
    private String fileName;
    private String fileSize;
    private Timestamp uploadedDate;
    private String type;
    private String contentType;
    private String deletedBy;
    private LocalDateTime deletedDate;
    private Boolean isDeleted;

    PmIdFileDetailsDtoBuilder() {
    }

    public PmIdFileDetailsDtoBuilder fileID(Long fileID) {
      this.fileID = fileID;
      return this;
    }

    public PmIdFileDetailsDtoBuilder requestID(Long requestID) {
      this.requestID = requestID;
      return this;
    }

    public PmIdFileDetailsDtoBuilder pmId(String pmId) {
      this.pmId = pmId;
      return this;
    }

    public PmIdFileDetailsDtoBuilder fileName(String fileName) {
      this.fileName = fileName;
      return this;
    }

    public PmIdFileDetailsDtoBuilder fileSize(String fileSize) {
      this.fileSize = fileSize;
      return this;
    }

    public PmIdFileDetailsDtoBuilder uploadedDate(Timestamp uploadedDate) {
      this.uploadedDate = uploadedDate;
      return this;
    }

    public PmIdFileDetailsDtoBuilder type(String type) {
      this.type = type;
      return this;
    }

    public PmIdFileDetailsDtoBuilder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    public PmIdFileDetailsDtoBuilder deletedBy(String deletedBy) {
      this.deletedBy = deletedBy;
      return this;
    }

    public PmIdFileDetailsDtoBuilder deletedDate(LocalDateTime deletedDate) {
      this.deletedDate = deletedDate;
      return this;
    }

    public PmIdFileDetailsDtoBuilder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }

    public PmIdFileDetailsDto build() {
      return new PmIdFileDetailsDto(fileID, requestID, pmId, fileName, fileSize, uploadedDate, type,
        contentType, deletedBy, deletedDate, isDeleted);
    }

    public String toString() {
      return "PmIdFileDetailsDto.PmIdFileDetailsDtoBuilder(fileID=" + this.fileID + ", requestID="
        + this.requestID + ", pmId=" + this.pmId + ", fileName=" + this.fileName + ", fileSize="
        + this.fileSize + ", uploadedDate=" + this.uploadedDate + ", type=" + this.type
        + ", contentType=" + this.contentType + ", deletedBy=" + this.deletedBy + ", deletedDate="
        + this.deletedDate + ", isDeleted=" + this.isDeleted + ")";
    }
  }
}
