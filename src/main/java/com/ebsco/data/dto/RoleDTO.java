package com.ebsco.data.dto;

import com.ebsco.data.entity.Module;
import java.util.ArrayList;
import java.util.List;

public class RoleDTO {

	private String roleid;
	private String rolename;

	private Boolean isadmin;

	private Boolean isteamadmin;

	private List<Module> modules = new ArrayList<>();

  public RoleDTO(String roleid, String rolename, Boolean isadmin, Boolean isteamadmin,
    List<Module> modules) {
    this.roleid = roleid;
    this.rolename = rolename;
    this.isadmin = isadmin;
    this.isteamadmin = isteamadmin;
    this.modules = modules;
  }

  public RoleDTO() {
  }

  public static RoleDTOBuilder builder() {
    return new RoleDTOBuilder();
  }

  public String getRoleid() {
    return this.roleid;
  }

  public String getRolename() {
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

  public void setRoleid(String roleid) {
    this.roleid = roleid;
  }

  public void setRolename(String rolename) {
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

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof RoleDTO)) {
      return false;
    }
    final RoleDTO other = (RoleDTO) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$roleid = this.getRoleid();
    final Object other$roleid = other.getRoleid();
    if (this$roleid == null ? other$roleid != null : !this$roleid.equals(other$roleid)) {
      return false;
    }
    final Object this$rolename = this.getRolename();
    final Object other$rolename = other.getRolename();
    if (this$rolename == null ? other$rolename != null : !this$rolename.equals(other$rolename)) {
      return false;
    }
    final Object this$isadmin = this.getIsadmin();
    final Object other$isadmin = other.getIsadmin();
    if (this$isadmin == null ? other$isadmin != null : !this$isadmin.equals(other$isadmin)) {
      return false;
    }
    final Object this$isteamadmin = this.getIsteamadmin();
    final Object other$isteamadmin = other.getIsteamadmin();
    if (this$isteamadmin == null ? other$isteamadmin != null
      : !this$isteamadmin.equals(other$isteamadmin)) {
      return false;
    }
    final Object this$modules = this.getModules();
    final Object other$modules = other.getModules();
    if (this$modules == null ? other$modules != null : !this$modules.equals(other$modules)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof RoleDTO;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $roleid = this.getRoleid();
    result = result * PRIME + ($roleid == null ? 43 : $roleid.hashCode());
    final Object $rolename = this.getRolename();
    result = result * PRIME + ($rolename == null ? 43 : $rolename.hashCode());
    final Object $isadmin = this.getIsadmin();
    result = result * PRIME + ($isadmin == null ? 43 : $isadmin.hashCode());
    final Object $isteamadmin = this.getIsteamadmin();
    result = result * PRIME + ($isteamadmin == null ? 43 : $isteamadmin.hashCode());
    final Object $modules = this.getModules();
    result = result * PRIME + ($modules == null ? 43 : $modules.hashCode());
    return result;
  }

  public String toString() {
    return "RoleDTO(roleid=" + this.getRoleid() + ", rolename=" + this.getRolename() + ", isadmin="
      + this.getIsadmin() + ", isteamadmin=" + this.getIsteamadmin() + ", modules="
      + this.getModules() + ")";
  }

  public static class RoleDTOBuilder {

    private String roleid;
    private String rolename;
    private Boolean isadmin;
    private Boolean isteamadmin;
    private List<Module> modules;

    RoleDTOBuilder() {
    }

    public RoleDTOBuilder roleid(String roleid) {
      this.roleid = roleid;
      return this;
    }

    public RoleDTOBuilder rolename(String rolename) {
      this.rolename = rolename;
      return this;
    }

    public RoleDTOBuilder isadmin(Boolean isadmin) {
      this.isadmin = isadmin;
      return this;
    }

    public RoleDTOBuilder isteamadmin(Boolean isteamadmin) {
      this.isteamadmin = isteamadmin;
      return this;
    }

    public RoleDTOBuilder modules(List<Module> modules) {
      this.modules = modules;
      return this;
    }

    public RoleDTO build() {
      return new RoleDTO(roleid, rolename, isadmin, isteamadmin, modules);
    }

    public String toString() {
      return "RoleDTO.RoleDTOBuilder(roleid=" + this.roleid + ", rolename=" + this.rolename
        + ", isadmin=" + this.isadmin + ", isteamadmin=" + this.isteamadmin + ", modules="
        + this.modules + ")";
    }
  }
}
