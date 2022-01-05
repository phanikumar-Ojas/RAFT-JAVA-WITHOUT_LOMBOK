package com.ebsco.transformer;

import com.ebsco.data.dto.PmIdFileDetailsDto;
import com.ebsco.data.entity.PmIdFileDetails;
import java.util.Objects;

public class PmIdFieldsTransformer {


  public static PmIdFileDetails toPmIdFileDetails(PmIdFileDetailsDto pmIdFileDetailsDto) {
    if (Objects.isNull(pmIdFileDetailsDto)) {
      return null;
    }
    return PmIdFileDetails.builder()
      .fileID(pmIdFileDetailsDto.getFileID())
      .contentType(pmIdFileDetailsDto.getContentType())
      .fileName(pmIdFileDetailsDto.getFileName())
      .fileSize(pmIdFileDetailsDto.getFileSize())
      .deletedDate(pmIdFileDetailsDto.getDeletedDate())
      .deletedBy(pmIdFileDetailsDto.getDeletedBy())
      .isDeleted(pmIdFileDetailsDto.getIsDeleted())
      .pmId(pmIdFileDetailsDto.getPmId())
      .requestID(pmIdFileDetailsDto.getRequestID())
      .type(pmIdFileDetailsDto.getType())
      .uploadedDate(pmIdFileDetailsDto.getUploadedDate())
      .build();


  }

  public static PmIdFileDetailsDto toPmIdFileDetailsDto(PmIdFileDetails pmIdFileDetails) {
    if (Objects.isNull(pmIdFileDetails)) {
      return null;
    }
    return PmIdFileDetailsDto.builder()
      .fileID(pmIdFileDetails.getFileID())
      .contentType(pmIdFileDetails.getContentType())
      .fileName(pmIdFileDetails.getFileName())
      .fileSize(pmIdFileDetails.getFileSize())
      .deletedDate(pmIdFileDetails.getDeletedDate())
      .deletedBy(pmIdFileDetails.getDeletedBy())
      .isDeleted(pmIdFileDetails.getIsDeleted())
      .pmId(pmIdFileDetails.getPmId())
      .requestID(pmIdFileDetails.getRequestID())
      .type(pmIdFileDetails.getType())
      .uploadedDate(pmIdFileDetails.getUploadedDate())
      .build();


  }

}
