package com.ebsco.data.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "pmidfiledetails")
public class PmIdFileDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pmIdFileSeq")
  @SequenceGenerator(initialValue = 4, allocationSize = 1, name = "pmIdFileSeq", sequenceName = "pmidfileseqence")
  @Column(name = "fileid")
  private Long fileID;

  @Column(name = "requestid")
  @NotNull(message = "requestid required but found null")
  private Long requestID;

  @Column(name = "pmid")
  @NotNull(message = "pmid required but found null")
  @NotBlank(message = "pmid required but found blank")
  @NotEmpty(message = "pmid required but found empty")
  @Size(min = 2, max = 20)
  private String pmId;

  @Column(name = "filename")
  @NotNull(message = "filename required but found null")
  @NotBlank(message = "filename required but found blank")
  @NotEmpty(message = "filename required but found empty")
  @Size(min = 4, max = 1000, message = "please enter a valid fileName with minimum length")
  private String fileName;

  @Column(name = "filesize")
  @NotNull(message = "filesize required but found null")
  @NotBlank(message = "filesize required but found blank")
  @NotEmpty(message = "filesize required but found empty")
  @Size(min = 1, message = "please enter a valid filesize with minimum length 1")
  private String fileSize;


  @Column(name = "uploadeddate")
  @UpdateTimestamp
  private Timestamp uploadedDate;

  @NotNull(message = "type required but found null")
  @NotBlank(message = "type required but found blank")
  @NotEmpty(message = "type required but found empty")
  @Size(min = 1, message = "please enter a valid type with minimum length 1")
  private String type;

  @Column(name = "contenttype")
  @NotNull(message = "contenttype required but found null")
  @NotBlank(message = "contenttype required but found blank")
  @NotEmpty(message = "contenttype required but found empty")
  @Size(min = 1, message = "please enter a valid contenttype with minimum length 1")
  private String contentType;

  @Column(name = "deletedby")
  private String deletedBy;

  @Column(name = "deleteddate")
  private LocalDateTime deletedDate;

  @Column(name = "isdeleted")
  private Boolean isDeleted;

  public PmIdFileDetails(Long fileID,
    @NotNull(message = "requestid required but found null") Long requestID,
    @NotNull(message = "pmid required but found null") @NotBlank(message = "pmid required but found blank") @NotEmpty(message = "pmid required but found empty") @Size(min = 2, max = 20) String pmId,
    @NotNull(message = "filename required but found null") @NotBlank(message = "filename required but found blank") @NotEmpty(message = "filename required but found empty") @Size(min = 4, max = 1000, message = "please enter a valid fileName with minimum length") String fileName,
    @NotNull(message = "filesize required but found null") @NotBlank(message = "filesize required but found blank") @NotEmpty(message = "filesize required but found empty") @Size(min = 1, message = "please enter a valid filesize with minimum length 1") String fileSize,
    Timestamp uploadedDate,
    @NotNull(message = "type required but found null") @NotBlank(message = "type required but found blank") @NotEmpty(message = "type required but found empty") @Size(min = 1, message = "please enter a valid type with minimum length 1") String type,
    @NotNull(message = "contenttype required but found null") @NotBlank(message = "contenttype required but found blank") @NotEmpty(message = "contenttype required but found empty") @Size(min = 1, message = "please enter a valid contenttype with minimum length 1") String contentType,
    String deletedBy, LocalDateTime deletedDate, Boolean isDeleted) {
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

  public PmIdFileDetails() {
  }

  public static PmIdFileDetailsBuilder builder() {
    return new PmIdFileDetailsBuilder();
  }

  public Long getFileID() {
    return this.fileID;
  }

  public @NotNull(message = "requestid required but found null") Long getRequestID() {
    return this.requestID;
  }

  public @NotNull(message = "pmid required but found null") @NotBlank(message = "pmid required but found blank") @NotEmpty(message = "pmid required but found empty") @Size(min = 2, max = 20) String getPmId() {
    return this.pmId;
  }

  public @NotNull(message = "filename required but found null") @NotBlank(message = "filename required but found blank") @NotEmpty(message = "filename required but found empty") @Size(min = 4, max = 1000, message = "please enter a valid fileName with minimum length") String getFileName() {
    return this.fileName;
  }

  public @NotNull(message = "filesize required but found null") @NotBlank(message = "filesize required but found blank") @NotEmpty(message = "filesize required but found empty") @Size(min = 1, message = "please enter a valid filesize with minimum length 1") String getFileSize() {
    return this.fileSize;
  }

  public Timestamp getUploadedDate() {
    return this.uploadedDate;
  }

  public @NotNull(message = "type required but found null") @NotBlank(message = "type required but found blank") @NotEmpty(message = "type required but found empty") @Size(min = 1, message = "please enter a valid type with minimum length 1") String getType() {
    return this.type;
  }

  public @NotNull(message = "contenttype required but found null") @NotBlank(message = "contenttype required but found blank") @NotEmpty(message = "contenttype required but found empty") @Size(min = 1, message = "please enter a valid contenttype with minimum length 1") String getContentType() {
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

  public void setRequestID(@NotNull(message = "requestid required but found null") Long requestID) {
    this.requestID = requestID;
  }

  public void setPmId(
    @NotNull(message = "pmid required but found null") @NotBlank(message = "pmid required but found blank") @NotEmpty(message = "pmid required but found empty") @Size(min = 2, max = 20) String pmId) {
    this.pmId = pmId;
  }

  public void setFileName(
    @NotNull(message = "filename required but found null") @NotBlank(message = "filename required but found blank") @NotEmpty(message = "filename required but found empty") @Size(min = 4, max = 1000, message = "please enter a valid fileName with minimum length") String fileName) {
    this.fileName = fileName;
  }

  public void setFileSize(
    @NotNull(message = "filesize required but found null") @NotBlank(message = "filesize required but found blank") @NotEmpty(message = "filesize required but found empty") @Size(min = 1, message = "please enter a valid filesize with minimum length 1") String fileSize) {
    this.fileSize = fileSize;
  }

  public void setUploadedDate(Timestamp uploadedDate) {
    this.uploadedDate = uploadedDate;
  }

  public void setType(
    @NotNull(message = "type required but found null") @NotBlank(message = "type required but found blank") @NotEmpty(message = "type required but found empty") @Size(min = 1, message = "please enter a valid type with minimum length 1") String type) {
    this.type = type;
  }

  public void setContentType(
    @NotNull(message = "contenttype required but found null") @NotBlank(message = "contenttype required but found blank") @NotEmpty(message = "contenttype required but found empty") @Size(min = 1, message = "please enter a valid contenttype with minimum length 1") String contentType) {
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
    return "PmIdFileDetails(fileID=" + this.getFileID() + ", requestID=" + this.getRequestID()
      + ", pmId=" + this.getPmId() + ", fileName=" + this.getFileName() + ", fileSize="
      + this.getFileSize() + ", uploadedDate=" + this.getUploadedDate() + ", type="
      + this.getType() + ", contentType=" + this.getContentType() + ", deletedBy="
      + this.getDeletedBy() + ", deletedDate=" + this.getDeletedDate() + ", isDeleted="
      + this.getIsDeleted() + ")";
  }

  public static class PmIdFileDetailsBuilder {

    private Long fileID;
    private @NotNull(message = "requestid required but found null") Long requestID;
    private @NotNull(message = "pmid required but found null") @NotBlank(message = "pmid required but found blank") @NotEmpty(message = "pmid required but found empty") @Size(min = 2, max = 20) String pmId;
    private @NotNull(message = "filename required but found null") @NotBlank(message = "filename required but found blank") @NotEmpty(message = "filename required but found empty") @Size(min = 4, max = 1000, message = "please enter a valid fileName with minimum length") String fileName;
    private @NotNull(message = "filesize required but found null") @NotBlank(message = "filesize required but found blank") @NotEmpty(message = "filesize required but found empty") @Size(min = 1, message = "please enter a valid filesize with minimum length 1") String fileSize;
    private Timestamp uploadedDate;
    private @NotNull(message = "type required but found null") @NotBlank(message = "type required but found blank") @NotEmpty(message = "type required but found empty") @Size(min = 1, message = "please enter a valid type with minimum length 1") String type;
    private @NotNull(message = "contenttype required but found null") @NotBlank(message = "contenttype required but found blank") @NotEmpty(message = "contenttype required but found empty") @Size(min = 1, message = "please enter a valid contenttype with minimum length 1") String contentType;
    private String deletedBy;
    private LocalDateTime deletedDate;
    private Boolean isDeleted;

    PmIdFileDetailsBuilder() {
    }

    public PmIdFileDetailsBuilder fileID(Long fileID) {
      this.fileID = fileID;
      return this;
    }

    public PmIdFileDetailsBuilder requestID(
      @NotNull(message = "requestid required but found null") Long requestID) {
      this.requestID = requestID;
      return this;
    }

    public PmIdFileDetailsBuilder pmId(
      @NotNull(message = "pmid required but found null") @NotBlank(message = "pmid required but found blank") @NotEmpty(message = "pmid required but found empty") @Size(min = 2, max = 20) String pmId) {
      this.pmId = pmId;
      return this;
    }

    public PmIdFileDetailsBuilder fileName(
      @NotNull(message = "filename required but found null") @NotBlank(message = "filename required but found blank") @NotEmpty(message = "filename required but found empty") @Size(min = 4, max = 1000, message = "please enter a valid fileName with minimum length") String fileName) {
      this.fileName = fileName;
      return this;
    }

    public PmIdFileDetailsBuilder fileSize(
      @NotNull(message = "filesize required but found null") @NotBlank(message = "filesize required but found blank") @NotEmpty(message = "filesize required but found empty") @Size(min = 1, message = "please enter a valid filesize with minimum length 1") String fileSize) {
      this.fileSize = fileSize;
      return this;
    }

    public PmIdFileDetailsBuilder uploadedDate(Timestamp uploadedDate) {
      this.uploadedDate = uploadedDate;
      return this;
    }

    public PmIdFileDetailsBuilder type(
      @NotNull(message = "type required but found null") @NotBlank(message = "type required but found blank") @NotEmpty(message = "type required but found empty") @Size(min = 1, message = "please enter a valid type with minimum length 1") String type) {
      this.type = type;
      return this;
    }

    public PmIdFileDetailsBuilder contentType(
      @NotNull(message = "contenttype required but found null") @NotBlank(message = "contenttype required but found blank") @NotEmpty(message = "contenttype required but found empty") @Size(min = 1, message = "please enter a valid contenttype with minimum length 1") String contentType) {
      this.contentType = contentType;
      return this;
    }

    public PmIdFileDetailsBuilder deletedBy(String deletedBy) {
      this.deletedBy = deletedBy;
      return this;
    }

    public PmIdFileDetailsBuilder deletedDate(LocalDateTime deletedDate) {
      this.deletedDate = deletedDate;
      return this;
    }

    public PmIdFileDetailsBuilder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }

    public PmIdFileDetails build() {
      return new PmIdFileDetails(fileID, requestID, pmId, fileName, fileSize, uploadedDate, type,
        contentType, deletedBy, deletedDate, isDeleted);
    }

    public String toString() {
      return "PmIdFileDetails.PmIdFileDetailsBuilder(fileID=" + this.fileID + ", requestID="
        + this.requestID + ", pmId=" + this.pmId + ", fileName=" + this.fileName + ", fileSize="
        + this.fileSize + ", uploadedDate=" + this.uploadedDate + ", type=" + this.type
        + ", contentType=" + this.contentType + ", deletedBy=" + this.deletedBy + ", deletedDate="
        + this.deletedDate + ", isDeleted=" + this.isDeleted + ")";
    }
  }
}
