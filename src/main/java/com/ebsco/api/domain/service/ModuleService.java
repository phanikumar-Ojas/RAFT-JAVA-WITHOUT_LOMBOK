package com.ebsco.api.domain.service;

import com.ebsco.data.dto.ModuleDTO;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.Module;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface ModuleService {

	Response getAllModules(@NotNull Integer pageSize, @NotNull Integer pageNumber);

	Module saveModule(@NotNull ModuleDTO module);

	Module getModuleById(@NotNull Integer moduleId);

	void deleteModuleById(@NotNull Integer moduleId);

	List<Module> getModulesByParentIds(@Valid List<Integer> parentIds);

  List<Module> getAllModules();

}
