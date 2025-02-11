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
 * Contact
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-11T17:08:12.432809600+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class Contact {

  private String phone;

  private String email;

  public Contact() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Contact(String phone, String email) {
    this.phone = phone;
    this.email = email;
  }

  public Contact phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
   */
  @NotNull 
  @Schema(name = "phone", example = "+1-800-555-0123", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Contact email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @NotNull 
  @Schema(name = "email", example = "contact@hotelcalifornia.com", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.phone, contact.phone) &&
        Objects.equals(this.email, contact.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phone, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

