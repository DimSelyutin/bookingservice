package com.booking.mapper;

import com.booking.entity.AddressEntity;
import com.booking.entity.Amenity;
import com.booking.entity.Hotel;
import com.booking.entity.util.HotelCountDTO;
import com.booking.entity.util.HotelSearchCriteria;
import com.booking.mapper.util.AddressMapper;
import com.booking.openapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;


/**
 * Mapper for converting Hotel objects to Hoteldetailsea.
 *
 * @author DimSelyutin
 */
@Mapper(componentModel = "spring",
        injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR, uses = AddressMapper.class)
public interface HotelMapper {


    @Mapping(target = "contacts", source = "hotel.contact")
    @Mapping(target = "address", source = "addressEntity")
    @Mapping(target = "amenities", expression = "java(convertAmenitiesToNames(hotel.getAmenities()))")
    HotelDetail toHotelDetailsDto(Hotel hotel);

    /**
     * Преобразование HotelDetailsDto в Hotel.
     *
     * @param newHotel объект NewHotel
     * @return объект Hotel
     */

    @Mapping(target = "contact", source = "contacts")
    @Mapping(target = "addressEntity", source = "address")
    Hotel toHotel(NewHotel newHotel);

    /**
     * Converts a list of Hotel entities to a list of HotelBrief DTOs.
     *
     * @param hotels list of Hotel entities to convert
     * @return list of converted HotelBrief DTOs
     */
    List<HotelBrief> toHotelBriefDtos(List<Hotel> hotels);

    /**
     * Converts a Hotel entity to a HotelBrief DTO.
     *
     * @param hotel the Hotel entity to convert
     * @return the converted HotelBrief DTO
     */
    @Mapping(target = "phone", source = "hotel.contact.phone")
    @Mapping(target = "address", expression = "java(mapAddress(hotel.getAddressEntity()))")
    HotelBrief toHotelBriefDto(Hotel hotel);

    HistogramDTO mapToModelDTO(HotelCountDTO hotelCountDTO);

    HotelSearchCriteria toHotelBriefSearchCriteria(HotelSearchCriteriaDTO dto);

    default List<String> convertAmenitiesToNames(List<Amenity> amenities) {
        if (amenities == null) {
            return Collections.emptyList();
        }
        return amenities.stream()
                .map(Amenity::getName)
                .toList();
    }

    default String mapAddress(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        String streetName = addressEntity.getStreet() != null ? addressEntity.getStreet().getName() : "";
        String cityName = addressEntity.getStreet() != null && addressEntity.getStreet().getCity() != null ? addressEntity.getStreet().getCity().getName() : "";
        String countryName = addressEntity.getStreet() != null && addressEntity.getStreet().getCity() != null && addressEntity.getStreet().getCity().getCountry() != null ?
                addressEntity.getStreet().getCity().getCountry().getName() : "";
        String postCode = addressEntity.getPostCode() != null ? addressEntity.getPostCode() : "";

        return String.format("%d %s, %s, %s, %s", addressEntity.getHouseNumber(), streetName, cityName, postCode, countryName);
    }
}
