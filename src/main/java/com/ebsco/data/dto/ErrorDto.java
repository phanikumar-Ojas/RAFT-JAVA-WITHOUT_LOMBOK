package com.ebsco.data.dto;

public class ErrorDto {

	private int statusCode;
	private String type;
	private String description;

  public ErrorDto() {
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public String getType() {
    return this.type;
  }

  public String getDescription() {
    return this.description;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ErrorDto)) {
      return false;
    }
    final ErrorDto other = (ErrorDto) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    if (this.getStatusCode() != other.getStatusCode()) {
      return false;
    }
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
      return false;
    }
    final Object this$description = this.getDescription();
    final Object other$description = other.getDescription();
    if (this$description == null ? other$description != null
      : !this$description.equals(other$description)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof ErrorDto;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + this.getStatusCode();
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    final Object $description = this.getDescription();
    result = result * PRIME + ($description == null ? 43 : $description.hashCode());
    return result;
  }

  public String toString() {
    return "ErrorDto(statusCode=" + this.getStatusCode() + ", type=" + this.getType()
      + ", description=" + this.getDescription() + ")";
  }
}
