package com.ebsco.api.domain.service;

import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.FullTextRequestDtoList;
import com.ebsco.data.dto.FullTextRsponseDto;
import com.ebsco.data.template.FullTextSearchTemplate;
import com.ebsco.data.dto.Response;
import java.util.List;

import com.ebsco.data.entity.FullTextRequest;

public interface FullTextService {

  List<FullTextRequestDto> findByPmId(List<Integer> id, String userName);

  List<FullTextRequest> findAll();

  Response searchForRequests(FullTextSearchTemplate searchTemplate);

  FullTextRequest save(FullTextRequest fullTextRequest);

  List<FullTextRequest> getLatest10Records();

  FullTextRequest getFullTextRequestById(Integer id, boolean isFetchable);

  FullTextRsponseDto saveFullTexts(FullTextRequestDtoList fullTextRequestDtoList);


}
