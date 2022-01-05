package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.service.FileCreatorService;
import com.ebsco.constants.EbescoConstants;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.util.FileUtils;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CSVFileCreatorServiceImpl implements FileCreatorService {

  // here you need to take your local paths
  private String filePath = "/home/ojas/raft/RAFT-Java/src/main/resources/files";

  @Override
  public String createFile(
    List<FullTextRequestDto> fullTextRequestDtoList) {

    try {
      List<String> fieldsList = EbescoConstants.FIELDS_LIST;
      List<String> columnsList = new LinkedList<>();
      String headers = fieldsList.stream().collect(Collectors.joining(","));

      columnsList.add(headers);
      convertFullTextRequestDtoToListOfStrings(fullTextRequestDtoList, columnsList);
      filePath =
        filePath + "/csvFile" + new SimpleDateFormat("ddMMyyyyhhmmss")
          .format(new Date()) + ".csv";
      byte[] joinedCsvString = columnsList.stream().collect(Collectors.joining("\n")).getBytes();

      Files.write(Paths.get(filePath), joinedCsvString, StandardOpenOption.CREATE);
      return new String(joinedCsvString);
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage());

    }

  }

  public void convertFullTextRequestDtoToListOfStrings(
    List<FullTextRequestDto> fullTextRequestDtos, List<String> data) {

    try {

      for (FullTextRequestDto fullTextRequestDto : fullTextRequestDtos) {
        List<String> list = new LinkedList<>();
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getPmId()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getJournalTitle()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getTitle()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getCitation()));
        list.add(FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
          fullTextRequestDto.getInstructions()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getPriority()));
        list.add(FileUtils.convertInstantToString(fullTextRequestDto.getCreationDate()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getRequestedBy()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getRequestID()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getNesId()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getStatus()));
        list.add(
          FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getFtRetrievedFrom()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getFullTextURL()));
        list.add(FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
          fullTextRequestDto.getFullTextFile()));
        list.add(
          FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getSupplementMaterial()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getNotes()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getIsReviewed()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getReviewedBy()));
        list.add(FileUtils.convertInstantToString(fullTextRequestDto.getReviewedOn()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getIsDeleted()));
        list.add(FileUtils.convertInstantToString(fullTextRequestDto.getDeletedOn()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getDeletedBy()));
        list.add(
          FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getDeleteRequestFrom()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getIsRequested()));
        list.add(
          FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getPurchaseOrSubscriptionType()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getCost()));
        list.add(
          FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getAutoRenewalURL()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getAutoRenewal()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getPubMedFTURL()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getEhostFTLink()));
        list.add(FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
          fullTextRequestDto.getIsSlamRecord()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getCostCenter()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getReOpened()));
        list.add(
          FileUtils.convertInstantToString(fullTextRequestDto.getFirstCreationDate()));
        list.add(
          FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getFirstRequestedBy()));
        list.add(FileUtils.convertInstantToString(fullTextRequestDto.getFirstReviewedOn()));
        list.add(
          FileUtils.returnNullIfNoValuePresentAndReplaceColonWithEmpty(
            fullTextRequestDto.getFirstReviewedBy()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getApiRequest()));
        list.add(FileUtils
          .returnNullIfNoValuePresentAndReplaceColonWithEmpty(fullTextRequestDto.getIsExist()));

        data.add(list.stream().collect(Collectors.joining(",")));


      }

    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage());
    }


  }
}
