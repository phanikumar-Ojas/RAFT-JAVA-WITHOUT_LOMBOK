package com.ebsco.api.domain.service;

import com.ebsco.data.template.UserSearchTemplate;
import com.ebsco.data.dto.ResetPasswordDto;
import java.util.List;
import java.util.Optional;

import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.UserDetails;
import javax.validation.constraints.NotNull;

public interface UserService {

  UserDetails save(UserDetails user);

  Optional<UserDetails> get(String userName);

  UserDetails findByEmail(String email);

  UserDetails findByUserNameAndPassword(String userName, String password);

  Response findAll(UserSearchTemplate detailsSearch);

  Response forgotPassword(@NotNull String email);

  Response updatePassword(ResetPasswordDto resetPasswordDto);

  List<UserDetails> findAllUsers();

  void deleteUserById(Integer userId);


}
