package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.repository.PmIdFileDetailsRepostory;
import com.ebsco.api.domain.service.PmIdFileDetailsService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.PmIdFileDetails;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmIdFileDetailsServiceImpl implements PmIdFileDetailsService {

  @Autowired
  private PmIdFileDetailsRepostory pmIdFileDetailsRepostory;


  @Override
  public PmIdFileDetails savePmIdFileDetails(
    @NotNull PmIdFileDetails pmIdFileDetails) {

    return pmIdFileDetailsRepostory.save(pmIdFileDetails);
  }

  @Override
  @Transactional
  public Response updatePmIdFileDetails(Long fileId, String deleteBy) {
    if (Objects.isNull(fileId)) {
      return Response.builder()
        .status(ExceptionMessage.DataIsEmpty)
        .res("fileId is required but found empty")
        .build();

    }
    if (Objects.isNull(deleteBy)) {
      return Response.builder()
        .status(ExceptionMessage.DataIsEmpty)
        .res("deleteBy is required but found empty")
        .build();

    }
    Optional<PmIdFileDetails> byId = pmIdFileDetailsRepostory.findById(fileId);
    if (byId.isPresent()) {
      int updatedCount = pmIdFileDetailsRepostory.updatePmIdFileDetails(fileId, deleteBy);
      if (updatedCount == 1) {
        return Response.builder()
          .status(ExceptionMessage.OK)
          .res("FileDetails updated successfully")
          .build();
      } else {
        return Response.builder()
          .status(ExceptionMessage.Bad_Request)
          .res("FileDetails Not updated")
          .build();
      }
    } else {
      return Response.builder()
        .status(ExceptionMessage.DataIsEmpty)
        .res("Data not found with the given fileId")
        .build();
    }

  }

  @Override
  public Response deleteByFileId(Long fileId) {
    Optional<PmIdFileDetails> byId = pmIdFileDetailsRepostory.findById(fileId);
    if (byId.isPresent()) {
      try {
        pmIdFileDetailsRepostory.deleteById(fileId);
        return Response.builder()
          .status(ExceptionMessage.OK)
          .res("FileDetails Deleted successfully")
          .build();
      } catch (Exception exception) {
        return Response.builder()
          .status(ExceptionMessage.Exception)
          .res(exception.getMessage())
          .build();
      }
    } else {
      return Response.builder()
        .status(ExceptionMessage.DataIsEmpty)
        .res("Data not found with the given fileId")
        .build();
    }
  }

  @Override
  public Response getPmIdFileIdDetailsByPmIdAnd(Integer pmId, String type) {
    PmIdFileDetails pmIdFileDetails = pmIdFileDetailsRepostory
      .getPmIdFileDetailsByPmIdAndType(pmId, type);
    if (Objects.nonNull(pmIdFileDetails)) {
      return Response.builder()
        .result(pmIdFileDetails)
        .status(ExceptionMessage.OK)
        .build();
    }

    return Response.builder()
      .status(ExceptionMessage.DataIsEmpty)
      .res("no Data found with the given pmId and type")
      .build();
  }
}
