package com.ebsco.data.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "modules")
public class Module implements Serializable {

  @Id
  @GeneratedValue(generator = "moduleIdseq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "moduleIdseq", sequenceName = "moduleIdsequence")
  @NotNull(message = "moduleId required but found null")
  @NotBlank(message = "moduleId required but found blank")
  @Column(name = "moduleid")
  private Integer moduleId;
  @NotNull(message = "moduleName required but found null")
  @NotBlank(message = "moduleName required but found blank")
  @Column(name = "modulename", length = 100)
  private String moduleName;
  @OneToOne
  @JoinColumn(name = "parentid")
  private Module parentId;
  @Column(name = "modulepath", length = 200)
  private String modulePath;
  @Column(name = "iconname", length = 200)
  private String iconName;
  @Column(name = "imagepath", length = 200)
  private String imagePath;

  @Column(name = "ordernumber")
  private Integer orderNumber;
  @Column(name = "openinchildwindow")
  private Boolean openInChildWindow;


  public Module(
    @NotNull(message = "moduleId required but found null") @NotBlank(message = "moduleId required but found blank") Integer moduleId,
    @NotNull(message = "moduleName required but found null") @NotBlank(message = "moduleName required but found blank") String moduleName,
    Module parentId, String modulePath, String iconName, String imagePath,
    Integer orderNumber, Boolean openInChildWindow) {
    this.moduleId = moduleId;
    this.moduleName = moduleName;
    this.parentId = parentId;
    this.modulePath = modulePath;
    this.iconName = iconName;
    this.imagePath = imagePath;
    this.orderNumber = orderNumber;
    this.openInChildWindow = openInChildWindow;
  }

  public Module() {
  }

  public static ModuleBuilder builder() {
    return new ModuleBuilder();
  }

  public @NotNull(message = "moduleId required but found null") @NotBlank(message = "moduleId required but found blank") Integer getModuleId() {
    return this.moduleId;
  }

  public @NotNull(message = "moduleName required but found null") @NotBlank(message = "moduleName required but found blank") String getModuleName() {
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

  public void setModuleId(
    @NotNull(message = "moduleId required but found null") @NotBlank(message = "moduleId required but found blank") Integer moduleId) {
    this.moduleId = moduleId;
  }

  public void setModuleName(
    @NotNull(message = "moduleName required but found null") @NotBlank(message = "moduleName required but found blank") String moduleName) {
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
    return "Module(moduleId=" + this.getModuleId() + ", moduleName=" + this.getModuleName()
      + ", parentId=" + this.getParentId() + ", modulePath=" + this.getModulePath()
      + ", iconName=" + this.getIconName() + ", imagePath=" + this.getImagePath()
      + ", orderNumber=" + this.getOrderNumber() + ", openInChildWindow="
      + this.getOpenInChildWindow() + ")";
  }

  public static class ModuleBuilder {

    private @NotNull(message = "moduleId required but found null") @NotBlank(message = "moduleId required but found blank") Integer moduleId;
    private @NotNull(message = "moduleName required but found null") @NotBlank(message = "moduleName required but found blank") String moduleName;
    private Module parentId;
    private String modulePath;
    private String iconName;
    private String imagePath;
    private Integer orderNumber;
    private Boolean openInChildWindow;

    ModuleBuilder() {
    }

    public ModuleBuilder moduleId(
      @NotNull(message = "moduleId required but found null") @NotBlank(message = "moduleId required but found blank") Integer moduleId) {
      this.moduleId = moduleId;
      return this;
    }

    public ModuleBuilder moduleName(
      @NotNull(message = "moduleName required but found null") @NotBlank(message = "moduleName required but found blank") String moduleName) {
      this.moduleName = moduleName;
      return this;
    }

    public ModuleBuilder parentId(Module parentId) {
      this.parentId = parentId;
      return this;
    }

    public ModuleBuilder modulePath(String modulePath) {
      this.modulePath = modulePath;
      return this;
    }

    public ModuleBuilder iconName(String iconName) {
      this.iconName = iconName;
      return this;
    }

    public ModuleBuilder imagePath(String imagePath) {
      this.imagePath = imagePath;
      return this;
    }

    public ModuleBuilder orderNumber(Integer orderNumber) {
      this.orderNumber = orderNumber;
      return this;
    }

    public ModuleBuilder openInChildWindow(Boolean openInChildWindow) {
      this.openInChildWindow = openInChildWindow;
      return this;
    }

    public Module build() {
      return new Module(moduleId, moduleName, parentId, modulePath, iconName, imagePath,
        orderNumber,
        openInChildWindow);
    }

    public String toString() {
      return "Module.ModuleBuilder(moduleId=" + this.moduleId + ", moduleName=" + this.moduleName
        + ", parentId=" + this.parentId + ", modulePath=" + this.modulePath + ", iconName="
        + this.iconName + ", imagePath=" + this.imagePath + ", orderNumber=" + this.orderNumber
        + ", openInChildWindow=" + this.openInChildWindow + ")";
    }
  }
}
