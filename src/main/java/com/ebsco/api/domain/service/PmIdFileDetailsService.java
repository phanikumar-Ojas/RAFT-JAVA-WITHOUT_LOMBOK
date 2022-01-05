package com.ebsco.api.domain.service;

import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.PmIdFileDetails;
import javax.validation.constraints.NotBlank;

public interface PmIdFileDetailsService {

  PmIdFileDetails savePmIdFileDetails(PmIdFileDetails pmIdFileDetails);

  Response updatePmIdFileDetails(Long fileId, String deletedBy);

  Response deleteByFileId(Long fileId);

  Response getPmIdFileIdDetailsByPmIdAnd(@NotBlank Integer pmId, @NotBlank String type);


}
