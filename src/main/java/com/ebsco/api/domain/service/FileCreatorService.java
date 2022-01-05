package com.ebsco.api.domain.service;

import com.ebsco.data.dto.FullTextRequestDto;
import java.util.List;

public interface FileCreatorService {

  String createFile(List<FullTextRequestDto> fullTextRequestDtoList);


}
