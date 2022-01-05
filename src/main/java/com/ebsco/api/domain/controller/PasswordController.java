package com.ebsco.api.domain.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import com.ebsco.api.domain.service.PasswordUUIDService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.RefferalsDto;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.RefferalFileDto;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/raft/password")
public class PasswordController {

  @Autowired
  private PasswordUUIDService passwordUUIDService;

  @GetMapping("/emailById/{id}")
  public Response getEmailById(@PathVariable String id) {

    String emailById = passwordUUIDService.getEmailById(id);

    if (Objects.nonNull(emailById) && StringUtils.isNotBlank(emailById) && StringUtils
      .isNotEmpty(emailById)) {
      return Response.builder().status(ExceptionMessage.OK).res(emailById).build();
    }
    return Response.builder().status(ExceptionMessage.DataIsEmpty)
      .res("email doesnt exists for given id").build();
  }

  @PostMapping(value = "/parse", consumes = {APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE})
  public Response parseFile(@RequestPart("refferalsDto") String refferalsDto,
    @RequestPart("file") MultipartFile file) throws IOException {

    RefferalsDto refferalsDto1 = new Gson().fromJson(refferalsDto, RefferalsDto.class);

//    System.out.println(refferalsDto1);
//    System.out.println(new String(file.getBytes()));
    refferalsDto1.setFile(file);

    RefferalFileDto convertedDto = convert(refferalsDto1);

    System.out.println(convertedDto.getFileContents());

    return null;

  }


  private RefferalFileDto convert(RefferalsDto refferalsDto) throws IOException {

    MultipartFile multipartFile = refferalsDto.getFile();
    String name = multipartFile.getName();
    String fileContent = new String(multipartFile.getBytes());

    return RefferalFileDto.builder().fileContents(fileContent).fileName(name)
      .fileLoadId(refferalsDto.getFileLoadId())
      .createTs(refferalsDto.getCreateTs())
      .updateTs(refferalsDto.getUpdateTs())
      .createUserNm(refferalsDto.getCreateUserNm())
      .senderName(refferalsDto.getSenderName())
      .fileType(refferalsDto.getFileType())
      .ortByteSize(refferalsDto.getOrtByteSize())
      .pickInd(refferalsDto.getPickInd())
      .recordsProcessed(refferalsDto.getRecordsProcessed())
      .referralLoadTxnId(refferalsDto.getReferralLoadTxnId())
      .totalRecordCount(refferalsDto.getTotalRecordCount())
      .updateUserNm(refferalsDto.getUpdateUserNm())
      .build();
  }


}
