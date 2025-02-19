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
 * ArrivalTime
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-19T11:27:53.123989100+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class ArrivalTime {

  private String checkIn;

  private String checkOut = null;

  public ArrivalTime() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ArrivalTime(String checkIn, String checkOut) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public ArrivalTime checkIn(String checkIn) {
    this.checkIn = checkIn;
    return this;
  }

  /**
   * Get checkIn
   * @return checkIn
   */
  @NotNull 
  @Schema(name = "checkIn", example = "15:00", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("checkIn")
  public String getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(String checkIn) {
    this.checkIn = checkIn;
  }

  public ArrivalTime checkOut(String checkOut) {
    this.checkOut = checkOut;
    return this;
  }

  /**
   * Get checkOut
   * @return checkOut
   */
  @NotNull 
  @Schema(name = "checkOut", example = "11:00", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("checkOut")
  public String getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(String checkOut) {
    this.checkOut = checkOut;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrivalTime arrivalTime = (ArrivalTime) o;
    return Objects.equals(this.checkIn, arrivalTime.checkIn) &&
        Objects.equals(this.checkOut, arrivalTime.checkOut);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkIn, checkOut);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArrivalTime {\n");
    sb.append("    checkIn: ").append(toIndentedString(checkIn)).append("\n");
    sb.append("    checkOut: ").append(toIndentedString(checkOut)).append("\n");
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

