package com.ebsco.api.domain.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.ebsco.api.domain.service.FullTextService;
import com.ebsco.api.domain.service.FullTextUtilService;
import com.ebsco.data.dto.FullTextRequestDto;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.data.exception.DataValidationException;

public class FullTextControllerTest {

  @InjectMocks
  FullTextController fullTextController;

  @Mock
  FullTextService service;

  @Mock
  FullTextUtilService fullTextUtilService;

//  @Mock
//  RabbitMQSender rabbitMQSender;

  @BeforeEach
  public void before() {
    openMocks(this);

  }

  @Test
  public void get_withValidRequest_shouldReturnExpectedData() {
    when(service.findByPmId(anyList(), anyString())).thenReturn(getFullTextRequest());
    when(fullTextUtilService.processIds(anyString())).thenReturn(Collections.singletonList(1));
    ResponseEntity<?> responseEntity = fullTextController.get("1", "aldo");

    List<FullTextRequest> fullTextRequests = (List<FullTextRequest>) responseEntity.getBody();
    assertNotNull(fullTextRequests);
    assertEquals(1, fullTextRequests.size());
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
  }

  @Test
  public void get_withNullResponse_ShouldReturn404StatusCode() {
    when(service.findByPmId(anyList(), anyString())).thenReturn(null);
    ResponseEntity<?> responseEntity = fullTextController.get("2", "aldo123");
    assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
  }

  @Test
  public void test_nullRequest_shouldThrowDataValidationException() {

    assertThrows(DataValidationException.class, () -> fullTextController.get(null, null));
  }

  public List<FullTextRequestDto> getFullTextRequest() {
    return Collections.singletonList(
      FullTextRequestDto.builder().apiRequest(true).autoRenewal(false)
        .autoRenewalURL("autoRenualURL")
        .citation("citation ").cost("1000").creationDate(Instant.now()).deletedBy("deletedBy")
        .deletedOn(Instant.now()).deleteRequestFrom("deleteRequest").ehostFTLink("ehostFTLink")
        .firstCreationDate(Instant.now()).firstRequestedBy("firstRequestedBy").build());

  }
}
