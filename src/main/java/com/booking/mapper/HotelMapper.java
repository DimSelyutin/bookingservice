package com.booking.mapper;

import com.booking.entity.Address;
import com.booking.entity.Hotel;
import com.booking.entity.util.HotelDetailsDto;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.NewHotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;


/**
 * Mapper for converting Hotel objects to Hoteldetailsea.
 *
 * @author DimSelyutin
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR)
public interface HotelMapper {

    /**
     * The Hotel object is being converted to the Hotel Details Dt o object.
     *
     * @param hotel object
     * @return HotelDetailsDto object
     */
    @Mapping(target = "address", source = "hotel.address")
    @Mapping(target = "contacts", source = "hotel.contact")
    HotelDetail toHotelDetailsDto(Hotel hotel);

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
    HotelBrief toHotelBriefDto(Hotel hotel);

    /**
     * Метод для преобразования Address в String.
     */
    default String mapAddress(Address address) {
        if (address == null) {
            return null;
        }
        return address.getHouseNumber() + " " + String.join(", ",
                address.getStreet(),
                address.getCity(),
                address.getPostCode(),
                address.getCountry()
        );
    }
}
