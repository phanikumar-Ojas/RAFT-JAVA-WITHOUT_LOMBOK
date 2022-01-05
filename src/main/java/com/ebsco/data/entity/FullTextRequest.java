package com.ebsco.data.entity;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@Entity
@Table(name = "fulltextrequestinfo")
public class FullTextRequest implements Serializable {

  @Id
  @Column(name = "requestid")
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "requIdSeq")
  @SequenceGenerator(initialValue = 88,allocationSize = 1,name = "requIdSeq",sequenceName = "fulltextsequence")
  private Integer requestID;

  @Column(name = "pmid")
  private Integer pmId;

	@Column(name = "journaltitle")
	private String journalTitle;

	private String title;

	private String citation;

	private String instructions;

	private String priority;

	@Column(name = "creationdate")
	private Instant creationDate;

	@Column(name = "requestedby")
	private String requestedBy;

	@Column(name = "nesid")
	private String nesId;

	private String status;

	@Column(name = "ftretrievedfrom")
	private String ftRetrievedFrom;

	@Column(name = "fulltexturl")
	private String fullTextURL;

	@Column(name = "fulltextfile")
	private String fullTextFile;

	@Column(name = "supplementmaterial")
	private String supplementMaterial;

	private String notes;

	@Column(name = "isreviewed")
	private Boolean isReviewed;

	@Column(name = "reviewedby")
	private String reviewedBy;

	@Column(name = "reviewedon")
	private Instant reviewedOn;

	@Column(name = "isdeleted")
	private Boolean isDeleted;

	@Column(name = "deletedon")
	private Instant deletedOn;

	@Column(name = "deletedby")
	private String deletedBy;

	@Column(name = "deleterequestfrom")
	private String deleteRequestFrom;

	@Column(name = "isrequested")
	private Boolean isRequested;

	@Column(name = "purchaseorsubscriptiontype")
	private String purchaseOrSubscriptionType;

	private String cost;

	@Column(name = "autorenewalurl")
	private String autoRenewalURL;

	@Column(name = "autorenewal")
	private Boolean autoRenewal;

	@Column(name = "pubmedfturl")
	private String pubMedFTURL;

	@Column(name = "ehostftlink")
	private String ehostFTLink;

	@Column(name = "isslamrecord")
	private Boolean isSlamRecord;

	@Column(name = "costcenter")
	private String costCenter;

	@Column(name = "reopened")
	private Boolean reOpened;

	@Column(name = "firstcreationdate")
	private Instant firstCreationDate;

	@Column(name = "firstrequestedby")
	private String firstRequestedBy;

	@Column(name = "firstreviewedon")
	private Instant firstReviewedOn;

	@Column(name = "firstreviewedby")
	private String firstReviewedBy;

	@Column(name = "apirequest")
	private Boolean apiRequest;

  public FullTextRequest(Integer requestID, Integer pmId, String journalTitle, String title,
    String citation, String instructions, String priority, Instant creationDate,
    String requestedBy, String nesId, String status, String ftRetrievedFrom, String fullTextURL,
    String fullTextFile, String supplementMaterial, String notes, Boolean isReviewed,
    String reviewedBy, Instant reviewedOn, Boolean isDeleted, Instant deletedOn, String deletedBy,
    String deleteRequestFrom, Boolean isRequested, String purchaseOrSubscriptionType, String cost,
    String autoRenewalURL, Boolean autoRenewal, String pubMedFTURL, String ehostFTLink,
    Boolean isSlamRecord, String costCenter, Boolean reOpened, Instant firstCreationDate,
    String firstRequestedBy, Instant firstReviewedOn, String firstReviewedBy,
    Boolean apiRequest) {
    this.requestID = requestID;
    this.pmId = pmId;
    this.journalTitle = journalTitle;
    this.title = title;
    this.citation = citation;
    this.instructions = instructions;
    this.priority = priority;
    this.creationDate = creationDate;
    this.requestedBy = requestedBy;
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
  }

  public FullTextRequest() {
  }

  public static FullTextRequestBuilder builder() {
    return new FullTextRequestBuilder();
  }

  public Integer getRequestID() {
    return this.requestID;
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

  public void setRequestID(Integer requestID) {
    this.requestID = requestID;
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

  public String toString() {
    return "FullTextRequest(requestID=" + this.getRequestID() + ", pmId=" + this.getPmId()
      + ", journalTitle=" + this.getJournalTitle() + ", title=" + this.getTitle() + ", citation="
      + this.getCitation() + ", instructions=" + this.getInstructions() + ", priority="
      + this.getPriority() + ", creationDate=" + this.getCreationDate() + ", requestedBy="
      + this.getRequestedBy() + ", nesId=" + this.getNesId() + ", status=" + this.getStatus()
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
      + ", apiRequest=" + this.getApiRequest() + ")";
  }

  public static class FullTextRequestBuilder {

    private Integer requestID;
    private Integer pmId;
    private String journalTitle;
    private String title;
    private String citation;
    private String instructions;
    private String priority;
    private Instant creationDate;
    private String requestedBy;
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

    FullTextRequestBuilder() {
    }

    public FullTextRequestBuilder requestID(Integer requestID) {
      this.requestID = requestID;
      return this;
    }

    public FullTextRequestBuilder pmId(Integer pmId) {
      this.pmId = pmId;
      return this;
    }

    public FullTextRequestBuilder journalTitle(String journalTitle) {
      this.journalTitle = journalTitle;
      return this;
    }

    public FullTextRequestBuilder title(String title) {
      this.title = title;
      return this;
    }

    public FullTextRequestBuilder citation(String citation) {
      this.citation = citation;
      return this;
    }

    public FullTextRequestBuilder instructions(String instructions) {
      this.instructions = instructions;
      return this;
    }

    public FullTextRequestBuilder priority(String priority) {
      this.priority = priority;
      return this;
    }

    public FullTextRequestBuilder creationDate(Instant creationDate) {
      this.creationDate = creationDate;
      return this;
    }

    public FullTextRequestBuilder requestedBy(String requestedBy) {
      this.requestedBy = requestedBy;
      return this;
    }

    public FullTextRequestBuilder nesId(String nesId) {
      this.nesId = nesId;
      return this;
    }

    public FullTextRequestBuilder status(String status) {
      this.status = status;
      return this;
    }

    public FullTextRequestBuilder ftRetrievedFrom(String ftRetrievedFrom) {
      this.ftRetrievedFrom = ftRetrievedFrom;
      return this;
    }

    public FullTextRequestBuilder fullTextURL(String fullTextURL) {
      this.fullTextURL = fullTextURL;
      return this;
    }

    public FullTextRequestBuilder fullTextFile(String fullTextFile) {
      this.fullTextFile = fullTextFile;
      return this;
    }

    public FullTextRequestBuilder supplementMaterial(String supplementMaterial) {
      this.supplementMaterial = supplementMaterial;
      return this;
    }

    public FullTextRequestBuilder notes(String notes) {
      this.notes = notes;
      return this;
    }

    public FullTextRequestBuilder isReviewed(Boolean isReviewed) {
      this.isReviewed = isReviewed;
      return this;
    }

    public FullTextRequestBuilder reviewedBy(String reviewedBy) {
      this.reviewedBy = reviewedBy;
      return this;
    }

    public FullTextRequestBuilder reviewedOn(Instant reviewedOn) {
      this.reviewedOn = reviewedOn;
      return this;
    }

    public FullTextRequestBuilder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }

    public FullTextRequestBuilder deletedOn(Instant deletedOn) {
      this.deletedOn = deletedOn;
      return this;
    }

    public FullTextRequestBuilder deletedBy(String deletedBy) {
      this.deletedBy = deletedBy;
      return this;
    }

    public FullTextRequestBuilder deleteRequestFrom(String deleteRequestFrom) {
      this.deleteRequestFrom = deleteRequestFrom;
      return this;
    }

    public FullTextRequestBuilder isRequested(Boolean isRequested) {
      this.isRequested = isRequested;
      return this;
    }

    public FullTextRequestBuilder purchaseOrSubscriptionType(
      String purchaseOrSubscriptionType) {
      this.purchaseOrSubscriptionType = purchaseOrSubscriptionType;
      return this;
    }

    public FullTextRequestBuilder cost(String cost) {
      this.cost = cost;
      return this;
    }

    public FullTextRequestBuilder autoRenewalURL(String autoRenewalURL) {
      this.autoRenewalURL = autoRenewalURL;
      return this;
    }

    public FullTextRequestBuilder autoRenewal(Boolean autoRenewal) {
      this.autoRenewal = autoRenewal;
      return this;
    }

    public FullTextRequestBuilder pubMedFTURL(String pubMedFTURL) {
      this.pubMedFTURL = pubMedFTURL;
      return this;
    }

    public FullTextRequestBuilder ehostFTLink(String ehostFTLink) {
      this.ehostFTLink = ehostFTLink;
      return this;
    }

    public FullTextRequestBuilder isSlamRecord(Boolean isSlamRecord) {
      this.isSlamRecord = isSlamRecord;
      return this;
    }

    public FullTextRequestBuilder costCenter(String costCenter) {
      this.costCenter = costCenter;
      return this;
    }

    public FullTextRequestBuilder reOpened(Boolean reOpened) {
      this.reOpened = reOpened;
      return this;
    }

    public FullTextRequestBuilder firstCreationDate(Instant firstCreationDate) {
      this.firstCreationDate = firstCreationDate;
      return this;
    }

    public FullTextRequestBuilder firstRequestedBy(String firstRequestedBy) {
      this.firstRequestedBy = firstRequestedBy;
      return this;
    }

    public FullTextRequestBuilder firstReviewedOn(Instant firstReviewedOn) {
      this.firstReviewedOn = firstReviewedOn;
      return this;
    }

    public FullTextRequestBuilder firstReviewedBy(String firstReviewedBy) {
      this.firstReviewedBy = firstReviewedBy;
      return this;
    }

    public FullTextRequestBuilder apiRequest(Boolean apiRequest) {
      this.apiRequest = apiRequest;
      return this;
    }

    public FullTextRequest build() {
      return new FullTextRequest(requestID, pmId, journalTitle, title, citation, instructions,
        priority, creationDate, requestedBy, nesId, status, ftRetrievedFrom, fullTextURL,
        fullTextFile, supplementMaterial, notes, isReviewed, reviewedBy, reviewedOn, isDeleted,
        deletedOn, deletedBy, deleteRequestFrom, isRequested, purchaseOrSubscriptionType, cost,
        autoRenewalURL, autoRenewal, pubMedFTURL, ehostFTLink, isSlamRecord, costCenter, reOpened,
        firstCreationDate, firstRequestedBy, firstReviewedOn, firstReviewedBy, apiRequest);
    }

    public String toString() {
      return "FullTextRequest.FullTextRequestBuilder(requestID=" + this.requestID + ", pmId="
        + this.pmId + ", journalTitle=" + this.journalTitle + ", title=" + this.title
        + ", citation=" + this.citation + ", instructions=" + this.instructions + ", priority="
        + this.priority + ", creationDate=" + this.creationDate + ", requestedBy="
        + this.requestedBy + ", nesId=" + this.nesId + ", status=" + this.status
        + ", ftRetrievedFrom=" + this.ftRetrievedFrom + ", fullTextURL=" + this.fullTextURL
        + ", fullTextFile=" + this.fullTextFile + ", supplementMaterial=" + this.supplementMaterial
        + ", notes=" + this.notes + ", isReviewed=" + this.isReviewed + ", reviewedBy="
        + this.reviewedBy + ", reviewedOn=" + this.reviewedOn + ", isDeleted=" + this.isDeleted
        + ", deletedOn=" + this.deletedOn + ", deletedBy=" + this.deletedBy + ", deleteRequestFrom="
        + this.deleteRequestFrom + ", isRequested=" + this.isRequested
        + ", purchaseOrSubscriptionType=" + this.purchaseOrSubscriptionType + ", cost=" + this.cost
        + ", autoRenewalURL=" + this.autoRenewalURL + ", autoRenewal=" + this.autoRenewal
        + ", pubMedFTURL=" + this.pubMedFTURL + ", ehostFTLink=" + this.ehostFTLink
        + ", isSlamRecord=" + this.isSlamRecord + ", costCenter=" + this.costCenter + ", reOpened="
        + this.reOpened + ", firstCreationDate=" + this.firstCreationDate + ", firstRequestedBy="
        + this.firstRequestedBy + ", firstReviewedOn=" + this.firstReviewedOn + ", firstReviewedBy="
        + this.firstReviewedBy + ", apiRequest=" + this.apiRequest + ")";
    }
  }
}
