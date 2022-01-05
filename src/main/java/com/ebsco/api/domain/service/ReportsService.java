package com.ebsco.api.domain.service;

import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.Response;
import com.ebsco.data.template.ReportsSearchTemplate;
import java.util.List;

public interface ReportsService {

  List<FullTextRequestDto> getGridData();


  Response getReportsRequestBasedOnSearchTemplate(
    ReportsSearchTemplate reportsSearchTemplate);


}
