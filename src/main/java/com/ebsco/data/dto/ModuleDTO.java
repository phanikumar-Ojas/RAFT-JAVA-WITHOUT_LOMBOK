package com.ebsco.data.dto;

import com.ebsco.data.entity.Module;

public class ModuleDTO {
	private Integer moduleId;
	private String moduleName;
	private Module parentId;
	private String modulePath;
	private String iconName;
	private String imagePath;

	private Integer orderNumber;
	private Boolean openInChildWindow;

  public ModuleDTO(Integer moduleId, String moduleName, Module parentId, String modulePath,
    String iconName, String imagePath, Integer orderNumber, Boolean openInChildWindow) {
    this.moduleId = moduleId;
    this.moduleName = moduleName;
    this.parentId = parentId;
    this.modulePath = modulePath;
    this.iconName = iconName;
    this.imagePath = imagePath;
    this.orderNumber = orderNumber;
    this.openInChildWindow = openInChildWindow;
  }

  public static ModuleDTOBuilder builder() {
    return new ModuleDTOBuilder();
  }

  public Integer getModuleId() {
    return this.moduleId;
  }

  public String getModuleName() {
    return this.moduleName;
  }

  public Module getParentId() {
    return this.parentId;
  }

  public String getModulePath() {
    return this.modulePath;
  }

  public String getIconName() {
    return this.iconName;
  }

  public String getImagePath() {
    return this.imagePath;
  }

  public Integer getOrderNumber() {
    return this.orderNumber;
  }

  public Boolean getOpenInChildWindow() {
    return this.openInChildWindow;
  }

  public void setModuleId(Integer moduleId) {
    this.moduleId = moduleId;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  public void setParentId(Module parentId) {
    this.parentId = parentId;
  }

  public void setModulePath(String modulePath) {
    this.modulePath = modulePath;
  }

  public void setIconName(String iconName) {
    this.iconName = iconName;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  public void setOpenInChildWindow(Boolean openInChildWindow) {
    this.openInChildWindow = openInChildWindow;
  }

  public String toString() {
    return "ModuleDTO(moduleId=" + this.getModuleId() + ", moduleName=" + this.getModuleName()
      + ", parentId=" + this.getParentId() + ", modulePath=" + this.getModulePath()
      + ", iconName=" + this.getIconName() + ", imagePath=" + this.getImagePath()
      + ", orderNumber=" + this.getOrderNumber() + ", openInChildWindow="
      + this.getOpenInChildWindow() + ")";
  }

  public static class ModuleDTOBuilder {

    private Integer moduleId;
    private String moduleName;
    private Module parentId;
    private String modulePath;
    private String iconName;
    private String imagePath;
    private Integer orderNumber;
    private Boolean openInChildWindow;

    ModuleDTOBuilder() {
    }

    public ModuleDTOBuilder moduleId(Integer moduleId) {
      this.moduleId = moduleId;
      return this;
    }

    public ModuleDTOBuilder moduleName(String moduleName) {
      this.moduleName = moduleName;
      return this;
    }

    public ModuleDTOBuilder parentId(Module parentId) {
      this.parentId = parentId;
      return this;
    }

    public ModuleDTOBuilder modulePath(String modulePath) {
      this.modulePath = modulePath;
      return this;
    }

    public ModuleDTOBuilder iconName(String iconName) {
      this.iconName = iconName;
      return this;
    }

    public ModuleDTOBuilder imagePath(String imagePath) {
      this.imagePath = imagePath;
      return this;
    }

    public ModuleDTOBuilder orderNumber(Integer orderNumber) {
      this.orderNumber = orderNumber;
      return this;
    }

    public ModuleDTOBuilder openInChildWindow(Boolean openInChildWindow) {
      this.openInChildWindow = openInChildWindow;
      return this;
    }

    public ModuleDTO build() {
      return new ModuleDTO(moduleId, moduleName, parentId, modulePath, iconName, imagePath,
        orderNumber, openInChildWindow);
    }

    public String toString() {
      return "ModuleDTO.ModuleDTOBuilder(moduleId=" + this.moduleId + ", moduleName="
        + this.moduleName + ", parentId=" + this.parentId + ", modulePath=" + this.modulePath
        + ", iconName=" + this.iconName + ", imagePath=" + this.imagePath + ", orderNumber="
        + this.orderNumber + ", openInChildWindow=" + this.openInChildWindow + ")";
    }
  }
}
