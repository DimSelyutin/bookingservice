package com.booking.openapi.model;

import java.net.URI;
import java.util.Objects;
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
 * HotelSearchCriteriaDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-12T03:08:38.377363300+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
public class HotelSearchCriteriaDTO {

  private @Nullable String name;

  private @Nullable String brand;

  private @Nullable String city;

  private @Nullable String country;

  @Valid
  private List<String> amenities = new ArrayList<>();

  private @Nullable Integer page;

  private @Nullable Integer size;

  public HotelSearchCriteriaDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HotelSearchCriteriaDTO brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
   */
  
  @Schema(name = "brand", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("brand")
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public HotelSearchCriteriaDTO city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
   */
  
  @Schema(name = "city", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public HotelSearchCriteriaDTO country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   */
  
  @Schema(name = "country", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public HotelSearchCriteriaDTO amenities(List<String> amenities) {
    this.amenities = amenities;
    return this;
  }

  public HotelSearchCriteriaDTO addAmenitiesItem(String amenitiesItem) {
    if (this.amenities == null) {
      this.amenities = new ArrayList<>();
    }
    this.amenities.add(amenitiesItem);
    return this;
  }

  /**
   * Список удобств, которые должны быть в отеле, например: 'WiFi', 'Бассейн', 'Парковка'
   * @return amenities
   */
  
  @Schema(name = "amenities", description = "Список удобств, которые должны быть в отеле, например: 'WiFi', 'Бассейн', 'Парковка'", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amenities")
  public List<String> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<String> amenities) {
    this.amenities = amenities;
  }

  public HotelSearchCriteriaDTO page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
   */
  
  @Schema(name = "page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("page")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public HotelSearchCriteriaDTO size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
   */
  
  @Schema(name = "size", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelSearchCriteriaDTO hotelSearchCriteriaDTO = (HotelSearchCriteriaDTO) o;
    return Objects.equals(this.name, hotelSearchCriteriaDTO.name) &&
        Objects.equals(this.brand, hotelSearchCriteriaDTO.brand) &&
        Objects.equals(this.city, hotelSearchCriteriaDTO.city) &&
        Objects.equals(this.country, hotelSearchCriteriaDTO.country) &&
        Objects.equals(this.amenities, hotelSearchCriteriaDTO.amenities) &&
        Objects.equals(this.page, hotelSearchCriteriaDTO.page) &&
        Objects.equals(this.size, hotelSearchCriteriaDTO.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, brand, city, country, amenities, page, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HotelSearchCriteriaDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    amenities: ").append(toIndentedString(amenities)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

