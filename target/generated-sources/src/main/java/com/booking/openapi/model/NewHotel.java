package com.booking.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.booking.openapi.model.Address;
import com.booking.openapi.model.ArrivalTime;
import com.booking.openapi.model.Contact;
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
 * NewHotel
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-16T17:19:33.206639900+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class NewHotel {

  private String name;

  private @Nullable String description = null;

  private String brand;

  private @Nullable Address address;

  private Contact contacts;

  private ArrivalTime arrivalTime;

  public NewHotel() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewHotel(String name, String brand, Contact contacts, ArrivalTime arrivalTime) {
    this.name = name;
    this.brand = brand;
    this.contacts = contacts;
    this.arrivalTime = arrivalTime;
  }

  public NewHotel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the hotel.
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Hotel California", description = "The name of the hotel.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NewHotel description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A brief description of the hotel.
   * @return description
   */
  
  @Schema(name = "description", example = "A lovely place with a warm atmosphere.", description = "A brief description of the hotel.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NewHotel brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * The brand associated with the hotel.
   * @return brand
   */
  @NotNull 
  @Schema(name = "brand", example = "California Hotels", description = "The brand associated with the hotel.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("brand")
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public NewHotel address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   */
  @Valid 
  @Schema(name = "address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public NewHotel contacts(Contact contacts) {
    this.contacts = contacts;
    return this;
  }

  /**
   * Get contacts
   * @return contacts
   */
  @NotNull @Valid 
  @Schema(name = "contacts", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contacts")
  public Contact getContacts() {
    return contacts;
  }

  public void setContacts(Contact contacts) {
    this.contacts = contacts;
  }

  public NewHotel arrivalTime(ArrivalTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * Get arrivalTime
   * @return arrivalTime
   */
  @NotNull @Valid 
  @Schema(name = "arrivalTime", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("arrivalTime")
  public ArrivalTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(ArrivalTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewHotel newHotel = (NewHotel) o;
    return Objects.equals(this.name, newHotel.name) &&
        Objects.equals(this.description, newHotel.description) &&
        Objects.equals(this.brand, newHotel.brand) &&
        Objects.equals(this.address, newHotel.address) &&
        Objects.equals(this.contacts, newHotel.contacts) &&
        Objects.equals(this.arrivalTime, newHotel.arrivalTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, brand, address, contacts, arrivalTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewHotel {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
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

