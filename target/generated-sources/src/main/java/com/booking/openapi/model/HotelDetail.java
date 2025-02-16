package com.booking.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.booking.openapi.model.Address;
import com.booking.openapi.model.ArrivalTime;
import com.booking.openapi.model.Contact;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * HotelDetail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-16T18:02:07.312153900+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class HotelDetail {

  private @Nullable Integer id;

  private String name;

  private String brand;

  private @Nullable Address address;

  private Contact contacts;

  private ArrivalTime arrivalTime;

  @Valid
  private List<String> amenities = new ArrayList<>();

  public HotelDetail() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public HotelDetail(String name, String brand, Contact contacts, ArrivalTime arrivalTime, List<String> amenities) {
    this.name = name;
    this.brand = brand;
    this.contacts = contacts;
    this.arrivalTime = arrivalTime;
    this.amenities = amenities;
  }

  public HotelDetail id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the hotel.
   * @return id
   */
  
  @Schema(name = "id", description = "Unique identifier for the hotel.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public HotelDetail name(String name) {
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

  public HotelDetail brand(String brand) {
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

  public HotelDetail address(Address address) {
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

  public HotelDetail contacts(Contact contacts) {
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

  public HotelDetail arrivalTime(ArrivalTime arrivalTime) {
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

  public HotelDetail amenities(List<String> amenities) {
    this.amenities = amenities;
    return this;
  }

  public HotelDetail addAmenitiesItem(String amenitiesItem) {
    if (this.amenities == null) {
      this.amenities = new ArrayList<>();
    }
    this.amenities.add(amenitiesItem);
    return this;
  }

  /**
   * A list of amenities offered by the hotel.
   * @return amenities
   */
  @NotNull 
  @Schema(name = "amenities", example = "[\"Free WiFi\",\"Parking\"]", description = "A list of amenities offered by the hotel.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amenities")
  public List<String> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<String> amenities) {
    this.amenities = amenities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelDetail hotelDetail = (HotelDetail) o;
    return Objects.equals(this.id, hotelDetail.id) &&
        Objects.equals(this.name, hotelDetail.name) &&
        Objects.equals(this.brand, hotelDetail.brand) &&
        Objects.equals(this.address, hotelDetail.address) &&
        Objects.equals(this.contacts, hotelDetail.contacts) &&
        Objects.equals(this.arrivalTime, hotelDetail.arrivalTime) &&
        Objects.equals(this.amenities, hotelDetail.amenities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, brand, address, contacts, arrivalTime, amenities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HotelDetail {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
    sb.append("    amenities: ").append(toIndentedString(amenities)).append("\n");
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

