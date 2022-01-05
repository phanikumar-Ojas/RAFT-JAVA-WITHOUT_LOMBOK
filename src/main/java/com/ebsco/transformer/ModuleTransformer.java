package com.ebsco.transformer;

import javax.validation.constraints.NotNull;

import com.ebsco.data.dto.ModuleDTO;
import com.ebsco.data.entity.Module;

public class ModuleTransformer {

	public static Module fromDTOToEntity(@NotNull ModuleDTO dto) {
		return Module.builder().iconName(dto.getIconName()).imagePath(dto.getImagePath()).moduleId(dto.getModuleId())
				.moduleName(dto.getModuleName()).modulePath(dto.getModulePath())
				.openInChildWindow(dto.getOpenInChildWindow()).orderNumber(dto.getOrderNumber())
				.parentId(dto.getParentId()).build();
	}

	public static ModuleDTO fromEntityToDTO(@NotNull Module module) {
		return ModuleDTO.builder().iconName(module.getIconName()).imagePath(module.getImagePath())
				.moduleId(module.getModuleId()).moduleName(module.getModuleName()).modulePath(module.getModulePath())
				.openInChildWindow(module.getOpenInChildWindow()).orderNumber(module.getOrderNumber())
				.parentId(module.getParentId()).build();
	}
}
