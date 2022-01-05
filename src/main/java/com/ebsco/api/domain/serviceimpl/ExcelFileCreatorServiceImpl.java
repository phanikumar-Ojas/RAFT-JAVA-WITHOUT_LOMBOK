package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.service.FileCreatorService;
import com.ebsco.constants.EbescoConstants;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.util.FileUtils;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelFileCreatorServiceImpl implements FileCreatorService {

  //  @Value("${application.file.path}")
//  private String filePath="RAFT-Java/src/main/resources/files";
  // here you need to take your local path
  private String filePath = "/home/ojas/raft/RAFT-Java/src/main/resources/files";


  @Override
  public String createFile(
    List<FullTextRequestDto> fullTextRequestDtoList) {
    XSSFWorkbook workbook = new XSSFWorkbook();
    // excelProperties.getSheetname()
    XSSFSheet detailsSheet = workbook.createSheet("sheet");
    createHeadersRow(detailsSheet);
    int rowCount = 0;
    try {
      for (FullTextRequestDto fullTextRequestDto : fullTextRequestDtoList) {
        Row row1 = detailsSheet.createRow(++rowCount);
        row1.createCell(0)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getPmId()));
        row1.createCell(1)
          .setCellValue(com.ebsco.util.FileUtils
            .returnNullIfNoValuePresent(fullTextRequestDto.getJournalTitle()));
        row1.createCell(2)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getTitle()));
        row1.createCell(3)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getCitation()));
        row1.createCell(4)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getInstructions()));
        row1.createCell(5)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getPriority()));
        row1.createCell(6)
          .setCellValue(FileUtils.convertInstantToString(fullTextRequestDto.getCreationDate()));
        row1.createCell(7)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getRequestedBy()));
        row1.createCell(8)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getRequestID()));
        row1.createCell(9)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getNesId()));
        row1.createCell(10)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getStatus()));
        row1.createCell(11)
          .setCellValue(
            FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getFtRetrievedFrom()));
        row1.createCell(12)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getFullTextURL()));
        row1.createCell(13)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getFullTextFile()));
        row1.createCell(14)
          .setCellValue(
            FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getSupplementMaterial()));
        row1.createCell(15)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getNotes()));
        row1.createCell(16)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getIsReviewed()));
        row1.createCell(17)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getReviewedBy()));
        row1.createCell(18)
          .setCellValue(FileUtils.convertInstantToString(fullTextRequestDto.getReviewedOn()));
        row1.createCell(19)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getIsDeleted()));
        row1.createCell(20)
          .setCellValue(FileUtils.convertInstantToString(fullTextRequestDto.getDeletedOn()));
        row1.createCell(21)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getDeletedBy()));
        row1.createCell(22)
          .setCellValue(
            FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getDeleteRequestFrom()));
        row1.createCell(23)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getIsRequested()));
        row1.createCell(24).setCellValue(
          FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getPurchaseOrSubscriptionType()));
        row1.createCell(25)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getCost()));
        row1.createCell(26)
          .setCellValue(
            FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getAutoRenewalURL()));
        row1.createCell(27)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getAutoRenewal()));
        row1.createCell(28)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getPubMedFTURL()));
        row1.createCell(29)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getEhostFTLink()));
        row1.createCell(30)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getIsSlamRecord()));
        row1.createCell(31)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getCostCenter()));
        row1.createCell(32)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getReOpened()));
        row1.createCell(33)
          .setCellValue(
            FileUtils.convertInstantToString(fullTextRequestDto.getFirstCreationDate()));
        row1.createCell(34)
          .setCellValue(
            FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getFirstRequestedBy()));
        row1.createCell(35)
          .setCellValue(FileUtils.convertInstantToString(fullTextRequestDto.getFirstReviewedOn()));
        row1.createCell(36)
          .setCellValue(
            FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getFirstReviewedBy()));
        row1.createCell(37)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getApiRequest()));
        row1.createCell(38)
          .setCellValue(FileUtils.returnNullIfNoValuePresent(fullTextRequestDto.getIsExist()));


      }
      filePath =
        filePath + "/myFile" + new SimpleDateFormat("ddMMyyyyhhmmss")
          .format(new Date()) + ".xlsx";
      File file = new File(filePath);
      FileOutputStream outputStream = new FileOutputStream(file);

      workbook.write(outputStream);
      Path p = Paths.get(file.getAbsolutePath());
      byte[] encodedBytes = Files.readAllBytes(p);

      return new String(encodedBytes);

    } catch (Exception exception) {
      exception.printStackTrace();
      throw new RuntimeException(exception.getMessage());
    }

  }

  @VisibleForTesting
  public void createHeadersRow(Sheet sheet) {
    Row row = sheet.createRow(0);
    List<String> fieldsList = EbescoConstants.FIELDS_LIST;
    for (int i = 0; i < fieldsList.size(); i++) {
      row.createCell(i).setCellValue(fieldsList.get(i));
    }


  }


}
