package com.ebsco.api.domain.service;

import com.ebsco.data.template.FullFillSearchTemplate;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.Response;
import java.util.List;

public interface FullFillService {

  List<FullTextRequestDto> getGridData();


  Response getFullFillRequestBasedOnSearchTemplate(
    FullFillSearchTemplate fullFillSearchTemplate);


}
