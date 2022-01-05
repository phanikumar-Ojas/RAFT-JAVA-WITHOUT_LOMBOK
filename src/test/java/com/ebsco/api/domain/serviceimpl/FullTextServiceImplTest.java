package com.ebsco.api.domain.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import com.ebsco.api.domain.repository.FullTextRepository;
import com.ebsco.api.domain.service.FullTextUtilService;
import com.ebsco.data.dto.FullTextRequestDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.data.exception.FullTextRequestDataNotFoundException;
import com.ebsco.api.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FullTextServiceImplTest {

  @Mock
  FullTextUtilService fullTextUtilService;
  @InjectMocks
  private FullTextServiceImpl fullTextServiceImpl;
  @Mock
  private FullTextRepository reposistory;

  @BeforeEach
  public void beforeEach() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void test_findByPmId_withNullIdAndValidUserName_shoudlThrowFullTextRequestDataNotFoundException() {

    List<FullTextRequestDto> fullTextRequestDtos = fullTextServiceImpl.findByPmId(null, "userName");

    assertNotNull(fullTextRequestDtos);
    assertEquals(fullTextRequestDtos.size(), 0);
  }

  @Test
  public void test_findByPmId_withIdAndNullUserName_shoudlThrowFullTextRequestDataNotFoundException() {

    FullTextRequestDataNotFoundException exception = assertThrows(
      FullTextRequestDataNotFoundException.class,
      () -> fullTextServiceImpl.findByPmId(Collections.singletonList(1), null));

    assertEquals(exception.getMessage(), "userName must required but found null");

  }

  @Test
	public void test_findByPmId_withIdAndEmptyUserName_shoudlThrowFullTextRequestDataNotFoundException() {

    FullTextRequestDataNotFoundException exception = assertThrows(
      FullTextRequestDataNotFoundException.class,
      () -> fullTextServiceImpl.findByPmId(Collections.singletonList(1), ""));

		assertEquals(exception.getMessage(), "userName must required but found empty");

	}

	@Test
	public void test_findByPmId_withIdAndBlankUserName_shoudlThrowFullTextRequestDataNotFoundException() {

    FullTextRequestDataNotFoundException exception = assertThrows(
      FullTextRequestDataNotFoundException.class,
      () -> fullTextServiceImpl.findByPmId(Collections.singletonList(1), " "));

		assertEquals(exception.getMessage(), "userName must required but found blank");

	}

	@Test
	public void test_findByPmId_withValidArguments_shouldReturnExpectedValueFromDB() {
    FullTextRequest fullTextRequest = FullTextRequest.builder().title("title").status("status")
      .reviewedBy("reviewedBy").citation("citation").priority("high").build();
    when(reposistory.getPmIdCount(anyInt())).thenReturn(1);

    when(reposistory.findByPmId(anyInt())).thenReturn(fullTextRequest);
    when(fullTextUtilService.getStatusOfFullTextRequest(anyString(), anyBoolean(),
      anyBoolean())).thenReturn("status");

    List<FullTextRequestDto> actualFullTextRequest = fullTextServiceImpl
      .findByPmId(Collections.singletonList(1), "userName");
    assertNotNull(actualFullTextRequest);
    assertEquals(actualFullTextRequest.size(), 1);

  }

	@Test
	public void test_findByPmId_withValidArguments_ShouldReturnExpectedValueFromPubMed() {
    when(reposistory.getPmIdCount(anyInt())).thenReturn(1);
    when(reposistory.findByPmId(anyInt())).thenReturn(null);

    NullPointerException exception = assertThrows(NullPointerException.class,
      () -> fullTextServiceImpl
        .findByPmId(Collections.singletonList(1), "userName"));
    assertEquals(exception.getMessage(), "fullTextRequest required but found null");

  }

}
