package com.ebsco.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.entity.FullTextRequest;

public class FullTextTransformer {


  public FullTextTransformer() {
  }

  public static FullTextRequestDto fromFullTextRequest(FullTextRequest fullTextRequest) {
    checkNotNull(fullTextRequest,"fullTextRequest required but found null");
    return FullTextRequestDto.builder().apiRequest(fullTextRequest.getApiRequest())
      .fullTextFile(fullTextRequest.getFullTextFile())
      .autoRenewal(fullTextRequest.getAutoRenewal())
      .autoRenewalURL(fullTextRequest.getAutoRenewalURL())
      .citation(fullTextRequest.getCitation())
      .cost(fullTextRequest.getCost())
      .costCenter(fullTextRequest.getCostCenter())
      .deleteRequestFrom(fullTextRequest.getDeleteRequestFrom())
      .creationDate(fullTextRequest.getCreationDate())
      .fullTextURL(fullTextRequest.getFullTextURL())
      .deletedBy(fullTextRequest.getDeletedBy())
      .deletedOn(fullTextRequest.getDeletedOn())
      .ehostFTLink(fullTextRequest.getEhostFTLink())
      .firstRequestedBy(fullTextRequest.getFirstRequestedBy())
      .firstCreationDate(fullTextRequest.getFirstCreationDate())
      .firstReviewedBy(fullTextRequest.getFirstReviewedBy())
      .ftRetrievedFrom(fullTextRequest.getFtRetrievedFrom())
      .firstReviewedOn(fullTextRequest.getFirstReviewedOn())
      .instructions(fullTextRequest.getInstructions())
      .isRequested(fullTextRequest.getIsRequested())
      .isDeleted(fullTextRequest.getIsDeleted())
      .isReviewed(fullTextRequest.getIsReviewed())
      .status(fullTextRequest.getStatus())
      .isSlamRecord(fullTextRequest.getIsSlamRecord())
      .journalTitle(fullTextRequest.getJournalTitle())
      .requestID(fullTextRequest.getRequestID())
      .nesId(fullTextRequest.getNesId())
      .notes(fullTextRequest.getNotes())
      .pmId(fullTextRequest.getPmId())
      .priority(fullTextRequest.getPriority())
      .pubMedFTURL(fullTextRequest.getPubMedFTURL())
      .title(fullTextRequest.getTitle())
      .requestedBy(fullTextRequest.getRequestedBy())
      .build();


  }

  public static FullTextRequest toFullTextRequest(FullTextRequestDto fullTextRequest) {
    return FullTextRequest.builder().apiRequest(fullTextRequest.getApiRequest())
      .fullTextFile(fullTextRequest.getFullTextFile())
      .autoRenewal(fullTextRequest.getAutoRenewal())
      .autoRenewalURL(fullTextRequest.getAutoRenewalURL())
      .citation(fullTextRequest.getCitation())
      .cost(fullTextRequest.getCost())
      .costCenter(fullTextRequest.getCostCenter())
      .deleteRequestFrom(fullTextRequest.getDeleteRequestFrom())
      .creationDate(fullTextRequest.getCreationDate())
      .fullTextURL(fullTextRequest.getFullTextURL())
      .deletedBy(fullTextRequest.getDeletedBy())
      .deletedOn(fullTextRequest.getDeletedOn())
      .ehostFTLink(fullTextRequest.getEhostFTLink())
      .firstRequestedBy(fullTextRequest.getFirstRequestedBy())
      .firstCreationDate(fullTextRequest.getFirstCreationDate())
      .firstReviewedBy(fullTextRequest.getFirstReviewedBy())
      .ftRetrievedFrom(fullTextRequest.getFtRetrievedFrom())
      .firstReviewedOn(fullTextRequest.getFirstReviewedOn())
      .instructions(fullTextRequest.getInstructions())
      .isRequested(fullTextRequest.getIsRequested())
      .isDeleted(fullTextRequest.getIsDeleted())
      .isReviewed(fullTextRequest.getIsReviewed())
      .status(fullTextRequest.getStatus())
      .isSlamRecord(fullTextRequest.getIsSlamRecord())
      .journalTitle(fullTextRequest.getJournalTitle())
      .requestID(fullTextRequest.getRequestID())
      .nesId(fullTextRequest.getNesId())
      .notes(fullTextRequest.getNotes())
      .pmId(fullTextRequest.getPmId())
      .priority(fullTextRequest.getPriority())
      .pubMedFTURL(fullTextRequest.getPubMedFTURL())
      .title(fullTextRequest.getTitle())
      .requestedBy(fullTextRequest.getRequestedBy())
      .build();


  }


}
