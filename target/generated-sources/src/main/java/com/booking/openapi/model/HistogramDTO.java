package com.booking.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * HistogramDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-19T11:19:30.414582500+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class HistogramDTO {

  private String name;

  private Long count;

  public HistogramDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public HistogramDTO(String name, Long count) {
    this.name = name;
    this.count = count;
  }

  public HistogramDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the parameter (for example, city, brand, etc.)
   * @return name
   */
  @NotNull 
  @Schema(name = "name", description = "The name of the parameter (for example, city, brand, etc.)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HistogramDTO count(Long count) {
    this.count = count;
    return this;
  }

  /**
   * The number of hotels associated with the parameter
   * @return count
   */
  @NotNull 
  @Schema(name = "count", description = "The number of hotels associated with the parameter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("count")
  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistogramDTO histogramDTO = (HistogramDTO) o;
    return Objects.equals(this.name, histogramDTO.name) &&
        Objects.equals(this.count, histogramDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistogramDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

