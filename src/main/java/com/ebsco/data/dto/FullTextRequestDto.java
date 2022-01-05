package com.ebsco.data.dto;

import java.time.Instant;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FullTextRequestDto {

  private Integer pmId;

  private String journalTitle;

  private String title;

  private String citation;

  private String instructions;

  private String priority;

  private Instant creationDate;

  private String requestedBy;

  private Integer requestID;

  private String nesId;

  private String status;

  private String ftRetrievedFrom;

  private String fullTextURL;

  private String fullTextFile;

  private String supplementMaterial;

  private String notes;

  private Boolean isReviewed;

  private String reviewedBy;

  private Instant reviewedOn;

  private Boolean isDeleted;

  private Instant deletedOn;

  private String deletedBy;

  private String deleteRequestFrom;

  private Boolean isRequested;

  private String purchaseOrSubscriptionType;

  private String cost;

  private String autoRenewalURL;

  private Boolean autoRenewal;

  private String pubMedFTURL;

  private String ehostFTLink;

  private Boolean isSlamRecord;

  private String costCenter;

  private Boolean reOpened;

  private Instant firstCreationDate;

  private String firstRequestedBy;

  private Instant firstReviewedOn;

  private String firstReviewedBy;

  private Boolean apiRequest;

  private Boolean isExist;


  public FullTextRequestDto(Integer pmId, String journalTitle, String title, String citation,
    String instructions, String priority, Instant creationDate, String requestedBy,
    Integer requestID, String nesId, String status, String ftRetrievedFrom, String fullTextURL,
    String fullTextFile, String supplementMaterial, String notes, Boolean isReviewed,
    String reviewedBy, Instant reviewedOn, Boolean isDeleted, Instant deletedOn, String deletedBy,
    String deleteRequestFrom, Boolean isRequested, String purchaseOrSubscriptionType, String cost,
    String autoRenewalURL, Boolean autoRenewal, String pubMedFTURL, String ehostFTLink,
    Boolean isSlamRecord, String costCenter, Boolean reOpened, Instant firstCreationDate,
    String firstRequestedBy, Instant firstReviewedOn, String firstReviewedBy, Boolean apiRequest,
    Boolean isExist) {
    this.pmId = pmId;
    this.journalTitle = journalTitle;
    this.title = title;
    this.citation = citation;
    this.instructions = instructions;
    this.priority = priority;
    this.creationDate = creationDate;
    this.requestedBy = requestedBy;
    this.requestID = requestID;
    this.nesId = nesId;
    this.status = status;
    this.ftRetrievedFrom = ftRetrievedFrom;
    this.fullTextURL = fullTextURL;
    this.fullTextFile = fullTextFile;
    this.supplementMaterial = supplementMaterial;
    this.notes = notes;
    this.isReviewed = isReviewed;
    this.reviewedBy = reviewedBy;
    this.reviewedOn = reviewedOn;
    this.isDeleted = isDeleted;
    this.deletedOn = deletedOn;
    this.deletedBy = deletedBy;
    this.deleteRequestFrom = deleteRequestFrom;
    this.isRequested = isRequested;
    this.purchaseOrSubscriptionType = purchaseOrSubscriptionType;
    this.cost = cost;
    this.autoRenewalURL = autoRenewalURL;
    this.autoRenewal = autoRenewal;
    this.pubMedFTURL = pubMedFTURL;
    this.ehostFTLink = ehostFTLink;
    this.isSlamRecord = isSlamRecord;
    this.costCenter = costCenter;
    this.reOpened = reOpened;
    this.firstCreationDate = firstCreationDate;
    this.firstRequestedBy = firstRequestedBy;
    this.firstReviewedOn = firstReviewedOn;
    this.firstReviewedBy = firstReviewedBy;
    this.apiRequest = apiRequest;
    this.isExist = isExist;
  }

  public FullTextRequestDto() {
  }

  public static FullTextRequestDtoBuilder builder() {
    return new FullTextRequestDtoBuilder();
  }

  public Integer getPmId() {
    return this.pmId;
  }

  public String getJournalTitle() {
    return this.journalTitle;
  }

  public String getTitle() {
    return this.title;
  }

  public String getCitation() {
    return this.citation;
  }

  public String getInstructions() {
    return this.instructions;
  }

  public String getPriority() {
    return this.priority;
  }

  public Instant getCreationDate() {
    return this.creationDate;
  }

  public String getRequestedBy() {
    return this.requestedBy;
  }

  public Integer getRequestID() {
    return this.requestID;
  }

  public String getNesId() {
    return this.nesId;
  }

  public String getStatus() {
    return this.status;
  }

  public String getFtRetrievedFrom() {
    return this.ftRetrievedFrom;
  }

  public String getFullTextURL() {
    return this.fullTextURL;
  }

  public String getFullTextFile() {
    return this.fullTextFile;
  }

  public String getSupplementMaterial() {
    return this.supplementMaterial;
  }

  public String getNotes() {
    return this.notes;
  }

  public Boolean getIsReviewed() {
    return this.isReviewed;
  }

  public String getReviewedBy() {
    return this.reviewedBy;
  }

  public Instant getReviewedOn() {
    return this.reviewedOn;
  }

  public Boolean getIsDeleted() {
    return this.isDeleted;
  }

  public Instant getDeletedOn() {
    return this.deletedOn;
  }

  public String getDeletedBy() {
    return this.deletedBy;
  }

  public String getDeleteRequestFrom() {
    return this.deleteRequestFrom;
  }

  public Boolean getIsRequested() {
    return this.isRequested;
  }

  public String getPurchaseOrSubscriptionType() {
    return this.purchaseOrSubscriptionType;
  }

  public String getCost() {
    return this.cost;
  }

  public String getAutoRenewalURL() {
    return this.autoRenewalURL;
  }

  public Boolean getAutoRenewal() {
    return this.autoRenewal;
  }

  public String getPubMedFTURL() {
    return this.pubMedFTURL;
  }

  public String getEhostFTLink() {
    return this.ehostFTLink;
  }

  public Boolean getIsSlamRecord() {
    return this.isSlamRecord;
  }

  public String getCostCenter() {
    return this.costCenter;
  }

  public Boolean getReOpened() {
    return this.reOpened;
  }

  public Instant getFirstCreationDate() {
    return this.firstCreationDate;
  }

  public String getFirstRequestedBy() {
    return this.firstRequestedBy;
  }

  public Instant getFirstReviewedOn() {
    return this.firstReviewedOn;
  }

  public String getFirstReviewedBy() {
    return this.firstReviewedBy;
  }

  public Boolean getApiRequest() {
    return this.apiRequest;
  }

  public Boolean getIsExist() {
    return this.isExist;
  }

  public void setPmId(Integer pmId) {
    this.pmId = pmId;
  }

  public void setJournalTitle(String journalTitle) {
    this.journalTitle = journalTitle;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCitation(String citation) {
    this.citation = citation;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public void setCreationDate(Instant creationDate) {
    this.creationDate = creationDate;
  }

  public void setRequestedBy(String requestedBy) {
    this.requestedBy = requestedBy;
  }

  public void setRequestID(Integer requestID) {
    this.requestID = requestID;
  }

  public void setNesId(String nesId) {
    this.nesId = nesId;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setFtRetrievedFrom(String ftRetrievedFrom) {
    this.ftRetrievedFrom = ftRetrievedFrom;
  }

  public void setFullTextURL(String fullTextURL) {
    this.fullTextURL = fullTextURL;
  }

  public void setFullTextFile(String fullTextFile) {
    this.fullTextFile = fullTextFile;
  }

  public void setSupplementMaterial(String supplementMaterial) {
    this.supplementMaterial = supplementMaterial;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setIsReviewed(Boolean isReviewed) {
    this.isReviewed = isReviewed;
  }

  public void setReviewedBy(String reviewedBy) {
    this.reviewedBy = reviewedBy;
  }

  public void setReviewedOn(Instant reviewedOn) {
    this.reviewedOn = reviewedOn;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public void setDeletedOn(Instant deletedOn) {
    this.deletedOn = deletedOn;
  }

  public void setDeletedBy(String deletedBy) {
    this.deletedBy = deletedBy;
  }

  public void setDeleteRequestFrom(String deleteRequestFrom) {
    this.deleteRequestFrom = deleteRequestFrom;
  }

  public void setIsRequested(Boolean isRequested) {
    this.isRequested = isRequested;
  }

  public void setPurchaseOrSubscriptionType(String purchaseOrSubscriptionType) {
    this.purchaseOrSubscriptionType = purchaseOrSubscriptionType;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

  public void setAutoRenewalURL(String autoRenewalURL) {
    this.autoRenewalURL = autoRenewalURL;
  }

  public void setAutoRenewal(Boolean autoRenewal) {
    this.autoRenewal = autoRenewal;
  }

  public void setPubMedFTURL(String pubMedFTURL) {
    this.pubMedFTURL = pubMedFTURL;
  }

  public void setEhostFTLink(String ehostFTLink) {
    this.ehostFTLink = ehostFTLink;
  }

  public void setIsSlamRecord(Boolean isSlamRecord) {
    this.isSlamRecord = isSlamRecord;
  }

  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
  }

  public void setReOpened(Boolean reOpened) {
    this.reOpened = reOpened;
  }

  public void setFirstCreationDate(Instant firstCreationDate) {
    this.firstCreationDate = firstCreationDate;
  }

  public void setFirstRequestedBy(String firstRequestedBy) {
    this.firstRequestedBy = firstRequestedBy;
  }

  public void setFirstReviewedOn(Instant firstReviewedOn) {
    this.firstReviewedOn = firstReviewedOn;
  }

  public void setFirstReviewedBy(String firstReviewedBy) {
    this.firstReviewedBy = firstReviewedBy;
  }

  public void setApiRequest(Boolean apiRequest) {
    this.apiRequest = apiRequest;
  }

  public void setIsExist(Boolean isExist) {
    this.isExist = isExist;
  }


  public String toString() {
    return "FullTextRequestDto(pmId=" + this.getPmId() + ", journalTitle=" + this.getJournalTitle()
      + ", title=" + this.getTitle() + ", citation=" + this.getCitation() + ", instructions="
      + this.getInstructions() + ", priority=" + this.getPriority() + ", creationDate="
      + this.getCreationDate() + ", requestedBy=" + this.getRequestedBy() + ", requestID="
      + this.getRequestID() + ", nesId=" + this.getNesId() + ", status=" + this.getStatus()
      + ", ftRetrievedFrom=" + this.getFtRetrievedFrom() + ", fullTextURL="
      + this.getFullTextURL() + ", fullTextFile=" + this.getFullTextFile()
      + ", supplementMaterial=" + this.getSupplementMaterial() + ", notes=" + this.getNotes()
      + ", isReviewed=" + this.getIsReviewed() + ", reviewedBy=" + this.getReviewedBy()
      + ", reviewedOn=" + this.getReviewedOn() + ", isDeleted=" + this.getIsDeleted()
      + ", deletedOn=" + this.getDeletedOn() + ", deletedBy=" + this.getDeletedBy()
      + ", deleteRequestFrom=" + this.getDeleteRequestFrom() + ", isRequested="
      + this.getIsRequested() + ", purchaseOrSubscriptionType="
      + this.getPurchaseOrSubscriptionType() + ", cost=" + this.getCost() + ", autoRenewalURL="
      + this.getAutoRenewalURL() + ", autoRenewal=" + this.getAutoRenewal() + ", pubMedFTURL="
      + this.getPubMedFTURL() + ", ehostFTLink=" + this.getEhostFTLink() + ", isSlamRecord="
      + this.getIsSlamRecord() + ", costCenter=" + this.getCostCenter() + ", reOpened="
      + this.getReOpened() + ", firstCreationDate=" + this.getFirstCreationDate()
      + ", firstRequestedBy=" + this.getFirstRequestedBy() + ", firstReviewedOn="
      + this.getFirstReviewedOn() + ", firstReviewedBy=" + this.getFirstReviewedBy()
      + ", apiRequest=" + this.getApiRequest() + ", isExist=" + this.getIsExist() + ")";
  }

  public static class FullTextRequestDtoBuilder {

    private Integer pmId;
    private String journalTitle;
    private String title;
    private String citation;
    private String instructions;
    private String priority;
    private Instant creationDate;
    private String requestedBy;
    private Integer requestID;
    private String nesId;
    private String status;
    private String ftRetrievedFrom;
    private String fullTextURL;
    private String fullTextFile;
    private String supplementMaterial;
    private String notes;
    private Boolean isReviewed;
    private String reviewedBy;
    private Instant reviewedOn;
    private Boolean isDeleted;
    private Instant deletedOn;
    private String deletedBy;
    private String deleteRequestFrom;
    private Boolean isRequested;
    private String purchaseOrSubscriptionType;
    private String cost;
    private String autoRenewalURL;
    private Boolean autoRenewal;
    private String pubMedFTURL;
    private String ehostFTLink;
    private Boolean isSlamRecord;
    private String costCenter;
    private Boolean reOpened;
    private Instant firstCreationDate;
    private String firstRequestedBy;
    private Instant firstReviewedOn;
    private String firstReviewedBy;
    private Boolean apiRequest;
    private Boolean isExist;

    FullTextRequestDtoBuilder() {
    }

    public FullTextRequestDtoBuilder pmId(Integer pmId) {
      this.pmId = pmId;
      return this;
    }

    public FullTextRequestDtoBuilder journalTitle(String journalTitle) {
      this.journalTitle = journalTitle;
      return this;
    }

    public FullTextRequestDtoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public FullTextRequestDtoBuilder citation(String citation) {
      this.citation = citation;
      return this;
    }

    public FullTextRequestDtoBuilder instructions(String instructions) {
      this.instructions = instructions;
      return this;
    }

    public FullTextRequestDtoBuilder priority(String priority) {
      this.priority = priority;
      return this;
    }

    public FullTextRequestDtoBuilder creationDate(Instant creationDate) {
      this.creationDate = creationDate;
      return this;
    }

    public FullTextRequestDtoBuilder requestedBy(String requestedBy) {
      this.requestedBy = requestedBy;
      return this;
    }

    public FullTextRequestDtoBuilder requestID(Integer requestID) {
      this.requestID = requestID;
      return this;
    }

    public FullTextRequestDtoBuilder nesId(String nesId) {
      this.nesId = nesId;
      return this;
    }

    public FullTextRequestDtoBuilder status(String status) {
      this.status = status;
      return this;
    }

    public FullTextRequestDtoBuilder ftRetrievedFrom(String ftRetrievedFrom) {
      this.ftRetrievedFrom = ftRetrievedFrom;
      return this;
    }

    public FullTextRequestDtoBuilder fullTextURL(String fullTextURL) {
      this.fullTextURL = fullTextURL;
      return this;
    }

    public FullTextRequestDtoBuilder fullTextFile(String fullTextFile) {
      this.fullTextFile = fullTextFile;
      return this;
    }

    public FullTextRequestDtoBuilder supplementMaterial(
      String supplementMaterial) {
      this.supplementMaterial = supplementMaterial;
      return this;
    }

    public FullTextRequestDtoBuilder notes(String notes) {
      this.notes = notes;
      return this;
    }

    public FullTextRequestDtoBuilder isReviewed(Boolean isReviewed) {
      this.isReviewed = isReviewed;
      return this;
    }

    public FullTextRequestDtoBuilder reviewedBy(String reviewedBy) {
      this.reviewedBy = reviewedBy;
      return this;
    }

    public FullTextRequestDtoBuilder reviewedOn(Instant reviewedOn) {
      this.reviewedOn = reviewedOn;
      return this;
    }

    public FullTextRequestDtoBuilder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }

    public FullTextRequestDtoBuilder deletedOn(Instant deletedOn) {
      this.deletedOn = deletedOn;
      return this;
    }

    public FullTextRequestDtoBuilder deletedBy(String deletedBy) {
      this.deletedBy = deletedBy;
      return this;
    }

    public FullTextRequestDtoBuilder deleteRequestFrom(String deleteRequestFrom) {
      this.deleteRequestFrom = deleteRequestFrom;
      return this;
    }

    public FullTextRequestDtoBuilder isRequested(Boolean isRequested) {
      this.isRequested = isRequested;
      return this;
    }

    public FullTextRequestDtoBuilder purchaseOrSubscriptionType(
      String purchaseOrSubscriptionType) {
      this.purchaseOrSubscriptionType = purchaseOrSubscriptionType;
      return this;
    }

    public FullTextRequestDtoBuilder cost(String cost) {
      this.cost = cost;
      return this;
    }

    public FullTextRequestDtoBuilder autoRenewalURL(String autoRenewalURL) {
      this.autoRenewalURL = autoRenewalURL;
      return this;
    }

    public FullTextRequestDtoBuilder autoRenewal(Boolean autoRenewal) {
      this.autoRenewal = autoRenewal;
      return this;
    }

    public FullTextRequestDtoBuilder pubMedFTURL(String pubMedFTURL) {
      this.pubMedFTURL = pubMedFTURL;
      return this;
    }

    public FullTextRequestDtoBuilder ehostFTLink(String ehostFTLink) {
      this.ehostFTLink = ehostFTLink;
      return this;
    }

    public FullTextRequestDtoBuilder isSlamRecord(Boolean isSlamRecord) {
      this.isSlamRecord = isSlamRecord;
      return this;
    }

    public FullTextRequestDtoBuilder costCenter(String costCenter) {
      this.costCenter = costCenter;
      return this;
    }

    public FullTextRequestDtoBuilder reOpened(Boolean reOpened) {
      this.reOpened = reOpened;
      return this;
    }

    public FullTextRequestDtoBuilder firstCreationDate(Instant firstCreationDate) {
      this.firstCreationDate = firstCreationDate;
      return this;
    }

    public FullTextRequestDtoBuilder firstRequestedBy(String firstRequestedBy) {
      this.firstRequestedBy = firstRequestedBy;
      return this;
    }

    public FullTextRequestDtoBuilder firstReviewedOn(Instant firstReviewedOn) {
      this.firstReviewedOn = firstReviewedOn;
      return this;
    }

    public FullTextRequestDtoBuilder firstReviewedBy(String firstReviewedBy) {
      this.firstReviewedBy = firstReviewedBy;
      return this;
    }

    public FullTextRequestDtoBuilder apiRequest(Boolean apiRequest) {
      this.apiRequest = apiRequest;
      return this;
    }

    public FullTextRequestDtoBuilder isExist(Boolean isExist) {
      this.isExist = isExist;
      return this;
    }

    public FullTextRequestDto build() {
      return new FullTextRequestDto(pmId, journalTitle, title, citation, instructions, priority,
        creationDate, requestedBy, requestID, nesId, status, ftRetrievedFrom, fullTextURL,
        fullTextFile, supplementMaterial, notes, isReviewed, reviewedBy, reviewedOn, isDeleted,
        deletedOn, deletedBy, deleteRequestFrom, isRequested, purchaseOrSubscriptionType, cost,
        autoRenewalURL, autoRenewal, pubMedFTURL, ehostFTLink, isSlamRecord, costCenter, reOpened,
        firstCreationDate, firstRequestedBy, firstReviewedOn, firstReviewedBy, apiRequest, isExist);
    }

    public String toString() {
      return "FullTextRequestDto.FullTextRequestDtoBuilder(pmId=" + this.pmId + ", journalTitle="
        + this.journalTitle + ", title=" + this.title + ", citation=" + this.citation
        + ", instructions=" + this.instructions + ", priority=" + this.priority + ", creationDate="
        + this.creationDate + ", requestedBy=" + this.requestedBy + ", requestID=" + this.requestID
        + ", nesId=" + this.nesId + ", status=" + this.status + ", ftRetrievedFrom="
        + this.ftRetrievedFrom + ", fullTextURL=" + this.fullTextURL + ", fullTextFile="
        + this.fullTextFile + ", supplementMaterial=" + this.supplementMaterial + ", notes="
        + this.notes + ", isReviewed=" + this.isReviewed + ", reviewedBy=" + this.reviewedBy
        + ", reviewedOn=" + this.reviewedOn + ", isDeleted=" + this.isDeleted + ", deletedOn="
        + this.deletedOn + ", deletedBy=" + this.deletedBy + ", deleteRequestFrom="
        + this.deleteRequestFrom + ", isRequested=" + this.isRequested
        + ", purchaseOrSubscriptionType=" + this.purchaseOrSubscriptionType + ", cost=" + this.cost
        + ", autoRenewalURL=" + this.autoRenewalURL + ", autoRenewal=" + this.autoRenewal
        + ", pubMedFTURL=" + this.pubMedFTURL + ", ehostFTLink=" + this.ehostFTLink
        + ", isSlamRecord=" + this.isSlamRecord + ", costCenter=" + this.costCenter + ", reOpened="
        + this.reOpened + ", firstCreationDate=" + this.firstCreationDate + ", firstRequestedBy="
        + this.firstRequestedBy + ", firstReviewedOn=" + this.firstReviewedOn + ", firstReviewedBy="
        + this.firstReviewedBy + ", apiRequest=" + this.apiRequest + ", isExist=" + this.isExist
        + ")";
    }
  }
}
