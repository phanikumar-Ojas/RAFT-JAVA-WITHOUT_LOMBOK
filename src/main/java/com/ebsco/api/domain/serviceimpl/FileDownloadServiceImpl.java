package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.service.FileCreatorService;
import com.ebsco.api.domain.service.FileDownloadService;
import com.ebsco.data.FileType;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.Response;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

  private FileCreatorService fileCreatorService;

  public FileDownloadServiceImpl() {

  }

  public FileDownloadServiceImpl(FileType fileType) {
    if (fileType.equals(FileType.csv)) {
      fileCreatorService = new com.ebsco.api.domain.serviceimpl.CSVFileCreatorServiceImpl();
    }
    if (fileType.equals(FileType.excel)) {
      fileCreatorService = new ExcelFileCreatorServiceImpl();
    }
  }

  @Override
  public String createFile(
    List<FullTextRequestDto> fullTextRequestDtos) {
    return fileCreatorService.createFile(fullTextRequestDtos);
  }


}
