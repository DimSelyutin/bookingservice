package com.booking.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Represents the structure of an error response returned by the API.
 */

@Schema(name = "ErrorDto", description = "Represents the structure of an error response returned by the API.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-11T17:08:12.432809600+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class ErrorDto {

  private Integer errorCode;

  private String errorMessage;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime timestamp;

  public ErrorDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorDto(Integer errorCode, String errorMessage, LocalDateTime timestamp) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.timestamp = timestamp;
  }

  public ErrorDto errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * A unique code indicating the type of error that occurred.
   * @return errorCode
   */
  @NotNull 
  @Schema(name = "errorCode", example = "404", description = "A unique code indicating the type of error that occurred.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errorCode")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public ErrorDto errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * A human-readable description of the error, suitable for logging and debugging.
   * @return errorMessage
   */
  @NotNull 
  @Schema(name = "errorMessage", example = "Resource not found.", description = "A human-readable description of the error, suitable for logging and debugging.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errorMessage")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ErrorDto timestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The time (in ISO 8601 format) when the error occurred.
   * @return timestamp
   */
  @NotNull @Valid 
  @Schema(name = "timestamp", example = "2023-10-05T14:48Z", description = "The time (in ISO 8601 format) when the error occurred.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDto errorDto = (ErrorDto) o;
    return Objects.equals(this.errorCode, errorDto.errorCode) &&
        Objects.equals(this.errorMessage, errorDto.errorMessage) &&
        Objects.equals(this.timestamp, errorDto.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, errorMessage, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

