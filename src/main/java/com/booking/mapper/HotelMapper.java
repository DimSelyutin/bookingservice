package com.booking.mapper;

import com.booking.entity.Address;
import com.booking.entity.Amenity;
import com.booking.entity.Hotel;
import com.booking.entity.util.HotelSearchCriteria;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.HotelSearchCriteriaDTO;
import com.booking.openapi.model.NewHotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Mapper for converting Hotel objects to Hoteldetailsea.
 *
 * @author DimSelyutin
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR)
public interface HotelMapper {

    @Mapping(target = "id", source = "hotel.id")
    @Mapping(target = "name", source = "hotel.name")
    @Mapping(target = "brand", source = "hotel.brand")
    @Mapping(target = "address", source = "hotel.address")
    @Mapping(target = "contacts", source = "hotel.contact")
    @Mapping(target = "arrivalTime", source = "hotel.arrivalTime")
    @Mapping(target = "amenities", expression = "java(convertAmenitiesToNames(hotel.getAmenities()))")
    HotelDetail toHotelDetailsDto(Hotel hotel);

    default List<String> convertAmenitiesToNames(List<Amenity> amenities) {
        if (amenities == null) {
            return Collections.emptyList();
        }
        return amenities.stream()
                .map(Amenity::getName) // Здесь предполагается, что вам нужно именно имя удобства
                .collect(Collectors.toList());
    }

    /**
     * Преобразование HotelDetailsDto в Hotel.
     *
     * @param newHotel объект NewHotel
     * @return объект Hotel
     */
    @Mappings({
            @Mapping(target = "name", source = "newHotel.name"),
            @Mapping(target = "description", source = "newHotel.description"),
            @Mapping(target = "brand", source = "newHotel.brand"),
            @Mapping(target = "address", source = "newHotel.address"),
            @Mapping(target = "contact", source = "newHotel.contacts"),
            @Mapping(target = "arrivalTime", source = "newHotel.arrivalTime")
    })
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
    HotelBrief toHotelBriefDto(Hotel hotel);


    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "brand", source = "dto.brand")
    @Mapping(target = "city", source = "dto.city")
    @Mapping(target = "country", source = "dto.country")
    @Mapping(target = "amenities", source = "dto.amenities")
    HotelSearchCriteria toHotelBriefSearchCriteria(HotelSearchCriteriaDTO dto);

    /**
     * Метод для преобразования Address в String.
     */
    default String mapAddress(Address address) {
        if (address == null) {
            return null;
        }
        return String.join(", ",
                address.getStreet(),
                address.getCity(),
                address.getPostCode()
        );
    }
}
