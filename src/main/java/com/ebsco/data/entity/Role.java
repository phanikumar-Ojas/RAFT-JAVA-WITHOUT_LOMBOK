package com.ebsco.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "roles")
public class Role implements Serializable {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleIdseq")
  @SequenceGenerator(initialValue = 5, allocationSize = 1, name = "roleIdseq", sequenceName = "roleidsequence")
  private Integer roleid;
  @Column(length = 200)
  @NotNull
  private String rolename;

  private Boolean isadmin;

	private Boolean isteamadmin;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rolemodules", joinColumns = @JoinColumn(name = "RoleID"), inverseJoinColumns = @JoinColumn(name = "ModuleID"))
	private List<Module> modules;


  public Role(@NotNull Integer roleid, @NotNull String rolename, Boolean isadmin,
    Boolean isteamadmin, List<Module> modules) {
    this.roleid = roleid;
    this.rolename = rolename;
    this.isadmin = isadmin;
    this.isteamadmin = isteamadmin;
    this.modules = modules;
  }

  public Role() {
  }

  public static RoleBuilder builder() {
    return new RoleBuilder();
  }

  public @NotNull Integer getRoleid() {
    return this.roleid;
  }

  public @NotNull String getRolename() {
    return this.rolename;
  }

  public Boolean getIsadmin() {
    return this.isadmin;
  }

  public Boolean getIsteamadmin() {
    return this.isteamadmin;
  }

  public List<Module> getModules() {
    return this.modules;
  }

  public void setRoleid(@NotNull Integer roleid) {
    this.roleid = roleid;
  }

  public void setRolename(@NotNull String rolename) {
    this.rolename = rolename;
  }

  public void setIsadmin(Boolean isadmin) {
    this.isadmin = isadmin;
  }

  public void setIsteamadmin(Boolean isteamadmin) {
    this.isteamadmin = isteamadmin;
  }

  public void setModules(List<Module> modules) {
    this.modules = modules;
  }

  public String toString() {
    return "Role(roleid=" + this.getRoleid() + ", rolename=" + this.getRolename() + ", isadmin="
      + this.getIsadmin() + ", isteamadmin=" + this.getIsteamadmin() + ", modules="
      + this.getModules() + ")";
  }

  public static class RoleBuilder {

    private @NotNull Integer roleid;
    private @NotNull String rolename;
    private Boolean isadmin;
    private Boolean isteamadmin;
    private List<Module> modules;

    RoleBuilder() {
    }

    public RoleBuilder roleid(@NotNull Integer roleid) {
      this.roleid = roleid;
      return this;
    }

    public RoleBuilder rolename(@NotNull String rolename) {
      this.rolename = rolename;
      return this;
    }

    public RoleBuilder isadmin(Boolean isadmin) {
      this.isadmin = isadmin;
      return this;
    }

    public RoleBuilder isteamadmin(Boolean isteamadmin) {
      this.isteamadmin = isteamadmin;
      return this;
    }

    public RoleBuilder modules(List<Module> modules) {
      this.modules = modules;
      return this;
    }

    public Role build() {
      return new Role(roleid, rolename, isadmin, isteamadmin, modules);
    }

    public String toString() {
      return "Role.RoleBuilder(roleid=" + this.roleid + ", rolename=" + this.rolename + ", isadmin="
        + this.isadmin + ", isteamadmin=" + this.isteamadmin + ", modules=" + this.modules + ")";
    }
  }
}
