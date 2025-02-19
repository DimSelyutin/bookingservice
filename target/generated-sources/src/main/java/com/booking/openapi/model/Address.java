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
 * Address
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-19T11:19:30.414582500+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class Address {

  private Integer houseNumber;

  private String street;

  private String city;

  private String country;

  private String postCode;

  public Address() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Address(Integer houseNumber, String street, String city, String country, String postCode) {
    this.houseNumber = houseNumber;
    this.street = street;
    this.city = city;
    this.country = country;
    this.postCode = postCode;
  }

  public Address houseNumber(Integer houseNumber) {
    this.houseNumber = houseNumber;
    return this;
  }

  /**
   * Get houseNumber
   * @return houseNumber
   */
  @NotNull 
  @Schema(name = "houseNumber", example = "123", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("houseNumber")
  public Integer getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(Integer houseNumber) {
    this.houseNumber = houseNumber;
  }

  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Get street
   * @return street
   */
  @NotNull 
  @Schema(name = "street", example = "Main St", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("street")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
   */
  @NotNull 
  @Schema(name = "city", example = "Los Angeles", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   */
  @NotNull 
  @Schema(name = "country", example = "Los Angeles Country", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Address postCode(String postCode) {
    this.postCode = postCode;
    return this;
  }

  /**
   * Get postCode
   * @return postCode
   */
  @NotNull 
  @Schema(name = "postCode", example = "90001", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("postCode")
  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.houseNumber, address.houseNumber) &&
        Objects.equals(this.street, address.street) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.country, address.country) &&
        Objects.equals(this.postCode, address.postCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(houseNumber, street, city, country, postCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    houseNumber: ").append(toIndentedString(houseNumber)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
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

