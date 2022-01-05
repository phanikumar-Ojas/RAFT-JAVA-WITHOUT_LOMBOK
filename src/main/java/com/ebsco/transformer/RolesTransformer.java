package com.ebsco.transformer;

import com.ebsco.data.dto.RoleDTO;
import com.ebsco.data.entity.Role;

public class RolesTransformer {

	public static Role fromDtoToEntity(RoleDTO dto) {

    return Role.builder().isadmin(dto.getIsadmin()).isteamadmin(dto.getIsteamadmin())
      .modules(dto.getModules())
      .roleid(dto.getRoleid() != null ? Integer.valueOf(dto.getRoleid()) : null)
      .rolename(dto.getRolename()).build();

  }

	public static RoleDTO fromEntityToDTO(Role roles) {

		return RoleDTO.builder().isadmin(roles.getIsadmin()).isteamadmin(roles.getIsteamadmin())
      .modules(roles.getModules()).rolename(roles.getRolename())
      .roleid(roles.getRoleid() != null ? String.valueOf(roles.getRoleid()) : null)
				.build();

	}

}
