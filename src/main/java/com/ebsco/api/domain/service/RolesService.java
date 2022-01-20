package com.ebsco.api.domain.service;

import javax.validation.constraints.NotNull;

import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.Role;

public interface RolesService {

	Response findAll(Integer pageSize,Integer pageNumber);

	Response save(@NotNull Role role);

	Role findById(String roleId);

  void deleteRoleById(Integer roleId);

}
