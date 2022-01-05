package com.ebsco.api.domain.serviceimpl;

import static com.google.common.base.Preconditions.checkArgument;

import com.ebsco.api.domain.service.EmailService;
import com.ebsco.api.domain.service.PasswordUUIDService;
import com.ebsco.data.dto.EmailDetails;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.Response;
import com.ebsco.data.template.UserSearchTemplate;
import com.ebsco.data.entity.UserDetails;
import com.ebsco.data.entity.PasswordUUIDDetails;
import com.ebsco.api.domain.repository.UserRepository;
import com.ebsco.api.domain.service.UserService;
import com.ebsco.util.EmailDataCreator;
import com.ebsco.util.LocalDateTimeUtils;
import com.ebsco.util.PaginationUtils;
import com.ebsco.util.ResetPasswordDto;
import com.ebsco.data.validation.StringDataValidator;
import com.google.common.base.Strings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository repository;

//  @Value("${spring.mail.username}")
//  private String from;

  @Autowired
  PasswordUUIDService passwordUUIDService;

  @Value("${application.password.expiry.time}")
  private String expiryTime;

  @Value("${application.password.forgotpassword.url}")
  private String url;

  @Qualifier("v1EmailServiceImpl")
  @Autowired
  EmailService emailService;


  @Override
  public UserDetails save(UserDetails user) {
    log.debug(String.format("The requested object is {}", user));

    return repository.save(user);
  }

  @Override
  public Optional<UserDetails> get(String userName) {
    return repository.findByEmpId(userName);
  }

  @Override
  public UserDetails findByEmail(String email) {
    UserDetails userDetails = repository.findByEmail(email);
    if (Objects.nonNull(userDetails)) {
      return userDetails;
    }
    return null;
  }

  @Override
  public UserDetails findByUserNameAndPassword(String userName, String password) {
    return repository.findByUserNameAndPassword(userName, password).orElse(null);

  }

  @Override
  public Response findAll(UserSearchTemplate detailsSearch) {
    Integer pageSize = PaginationUtils
      .getPageSize(detailsSearch.getPageSize(), detailsSearch.getPageNumber());
    List<UserDetails> userDetailsList;
    if (detailsSearch.getPageSize() != null && detailsSearch.getPageNumber() != null) {
      userDetailsList = repository.findAll(pageSize, detailsSearch.getPageSize(),
        detailsSearch.getEmpId(), detailsSearch.getEmpName(), detailsSearch.getCostCenter(),
        detailsSearch.getEmailId());
    } else {
      userDetailsList = repository.findAllWithOutPagination(
        detailsSearch.getEmpId(), detailsSearch.getEmpName(), detailsSearch.getCostCenter(),
        detailsSearch.getEmailId());
    }
    int totalRecords = repository.getAllUsersCount();
    int totalPages = 0;
    if (detailsSearch.getPageSize() != null) {
      totalPages = PaginationUtils.getTotalPages(totalRecords, detailsSearch.getPageSize());
    }
    Response response = new Response(userDetailsList, ExceptionMessage.OK);
    if (detailsSearch.getPageSize() != null && detailsSearch.getPageNumber() != null) {
      response.setTotalPages(totalPages);
      response.setTotalRecords(totalRecords);
    }

    return response;
  }

  @Override
  public Response forgotPassword(String email) {
    UserDetails userDetails;
    try {
      if (!Strings.isNullOrEmpty(email)) {
        userDetails = findByEmail(email);
        if (Objects.nonNull(userDetails)) {
          String generatedUUID = passwordUUIDService
            .storeUserDetails(userDetails.getEmpId(), userDetails.getUserid(), email);
          EmailDetails emailDetails = EmailDataCreator
            .createEmailDetails(userDetails, generatedUUID, url);
          emailDetails.setFrom(null);
          emailService.sendEmail(emailDetails);
          return Response.builder().status(ExceptionMessage.OK)
            .res("mail sent successfully to the email:" + email).build();
        } else {
          return Response.builder().status(ExceptionMessage.EmailNotExist).res("email doesnt exist")
            .build();
        }
      }
      return Response.builder()
        .res("Email found null or empty")
        .status(ExceptionMessage.Bad_Request).build();
    } catch (MailAuthenticationException mailConnectException) {
      return Response.builder().status(ExceptionMessage.Unauthorized)
        .res("problem with Authentication").build();
    } catch (Exception mailConnectException) {
      return Response.builder().status(ExceptionMessage.Exception)
        .res("error occured while connecting").build();
    }

  }

  @Override
  @Transactional
  public Response updatePassword(ResetPasswordDto resetPasswordDto) {
    String uuId = resetPasswordDto.getUuId();
    checkArgument(!Strings.isNullOrEmpty(uuId), "uuId must be required but found null or empty");
    checkArgument(StringUtils.isNotBlank(uuId), "uuId must be required but found blank");

    PasswordUUIDDetails userDetails = passwordUUIDService.getUserDetails(uuId);
    String differenceWithCurrentTime = LocalDateTimeUtils
      .differenceWithCurrentTime(userDetails.getCreatedTime());
    boolean validString = StringDataValidator.validateString(differenceWithCurrentTime);
    try {
      if (validString) {
        if (resetPasswordDto.getEmail().equalsIgnoreCase(userDetails.getEmail())) {

          if (Long.parseLong(differenceWithCurrentTime) <= Long.parseLong(expiryTime)) {

            int updatedCount = repository
              .updateUserPassword(userDetails.getUserName(), userDetails.getUserId(),
                resetPasswordDto.getNewPassword());

            if (updatedCount == 1) {
              return Response.builder().res("User Updated Succesfully").status(ExceptionMessage.OK)
                .build();
            } else {
              return Response.builder().res("Sorry User not updated").build();
            }

          } else {
            return Response.builder().status(ExceptionMessage.PassWordLinkExpired)
              .res("Link expired")
              .build();
          }
        }
        return Response.builder().res("Given Email Doesnt match with the actual email ")
          .status(ExceptionMessage.Bad_Request).build();
      }
    } catch (Exception exception) {
      return Response.builder()
        .res(exception.getMessage())
        .status(ExceptionMessage.Exception).build();
    }
    return Response.builder()
      .res("Some Other error occurred while updating the Password so data not saved")
      .status(ExceptionMessage.DataIsNotSaved).build();
  }

}
