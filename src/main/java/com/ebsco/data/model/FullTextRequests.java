package com.ebsco.data.model;

import com.ebsco.data.entity.FullTextRequest;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fullTextRequests")
@XmlAccessorType(XmlAccessType.FIELD)
public class FullTextRequests {

	@XmlElement(name = "request")
	List<FullTextRequest> fullTextRequest;

  public FullTextRequests(List<FullTextRequest> fullTextRequest) {
    this.fullTextRequest = fullTextRequest;
  }

  public FullTextRequests() {
  }

  public static FullTextRequestsBuilder builder() {
    return new FullTextRequestsBuilder();
  }

  public List<FullTextRequest> getFullTextRequest() {
    return this.fullTextRequest;
  }

  public void setFullTextRequest(List<FullTextRequest> fullTextRequest) {
    this.fullTextRequest = fullTextRequest;
  }

  public String toString() {
    return "FullTextRequests(fullTextRequest=" + this.getFullTextRequest() + ")";
  }

  public static class FullTextRequestsBuilder {

    private List<FullTextRequest> fullTextRequest;

    FullTextRequestsBuilder() {
    }

    public FullTextRequestsBuilder fullTextRequest(
      List<FullTextRequest> fullTextRequest) {
      this.fullTextRequest = fullTextRequest;
      return this;
    }

    public FullTextRequests build() {
      return new FullTextRequests(fullTextRequest);
    }

    public String toString() {
      return "FullTextRequests.FullTextRequestsBuilder(fullTextRequest=" + this.fullTextRequest
        + ")";
    }
  }
}
