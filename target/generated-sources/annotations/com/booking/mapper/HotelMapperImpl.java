package com.booking.mapper;

import com.booking.entity.Hotel;
import com.booking.entity.util.HotelCountDTO;
import com.booking.entity.util.HotelSearchCriteria;
import com.booking.mapper.util.AddressMapper;
import com.booking.openapi.model.ArrivalTime;
import com.booking.openapi.model.Contact;
import com.booking.openapi.model.HistogramDTO;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.HotelSearchCriteriaDTO;
import com.booking.openapi.model.NewHotel;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-16T18:07:16+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class HotelMapperImpl implements HotelMapper {

    private final AddressMapper addressMapper;

    @Autowired
    public HotelMapperImpl(AddressMapper addressMapper) {

        this.addressMapper = addressMapper;
    }

    @Override
    public HotelDetail toHotelDetailsDto(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelDetail hotelDetail = new HotelDetail();

        hotelDetail.setContacts( contactToContact( hotel.getContact() ) );
        hotelDetail.setAddress( addressMapper.toDto( hotel.getAddressEntity() ) );
        hotelDetail.setId( hotel.getId() );
        hotelDetail.setName( hotel.getName() );
        hotelDetail.setBrand( hotel.getBrand() );
        hotelDetail.setArrivalTime( arrivalTimeToArrivalTime( hotel.getArrivalTime() ) );

        hotelDetail.setAmenities( convertAmenitiesToNames(hotel.getAmenities()) );

        return hotelDetail;
    }

    @Override
    public Hotel toHotel(NewHotel newHotel) {
        if ( newHotel == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setContact( contactToContact1( newHotel.getContacts() ) );
        hotel.setAddressEntity( addressMapper.toEntity( newHotel.getAddress() ) );
        hotel.setName( newHotel.getName() );
        hotel.setDescription( newHotel.getDescription() );
        hotel.setBrand( newHotel.getBrand() );
        hotel.setArrivalTime( arrivalTimeToArrivalTime1( newHotel.getArrivalTime() ) );

        return hotel;
    }

    @Override
    public List<HotelBrief> toHotelBriefDtos(List<Hotel> hotels) {
        if ( hotels == null ) {
            return null;
        }

        List<HotelBrief> list = new ArrayList<HotelBrief>( hotels.size() );
        for ( Hotel hotel : hotels ) {
            list.add( toHotelBriefDto( hotel ) );
        }

        return list;
    }

    @Override
    public HotelBrief toHotelBriefDto(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelBrief hotelBrief = new HotelBrief();

        hotelBrief.setPhone( hotelContactPhone( hotel ) );
        hotelBrief.setId( hotel.getId() );
        hotelBrief.setName( hotel.getName() );
        hotelBrief.setDescription( hotel.getDescription() );
        hotelBrief.setBrand( hotel.getBrand() );

        hotelBrief.setAddress( mapAddress(hotel.getAddressEntity()) );

        return hotelBrief;
    }

    @Override
    public HistogramDTO mapToModelDTO(HotelCountDTO hotelCountDTO) {
        if ( hotelCountDTO == null ) {
            return null;
        }

        HistogramDTO histogramDTO = new HistogramDTO();

        histogramDTO.setName( hotelCountDTO.getName() );
        histogramDTO.setCount( hotelCountDTO.getCount() );

        return histogramDTO;
    }

    @Override
    public HotelSearchCriteria toHotelBriefSearchCriteria(HotelSearchCriteriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HotelSearchCriteria.HotelSearchCriteriaBuilder hotelSearchCriteria = HotelSearchCriteria.builder();

        hotelSearchCriteria.name( dto.getName() );
        hotelSearchCriteria.brand( dto.getBrand() );
        hotelSearchCriteria.city( dto.getCity() );
        hotelSearchCriteria.country( dto.getCountry() );
        List<String> list = dto.getAmenities();
        if ( list != null ) {
            hotelSearchCriteria.amenities( new ArrayList<String>( list ) );
        }

        return hotelSearchCriteria.build();
    }

    protected Contact contactToContact(com.booking.entity.Contact contact) {
        if ( contact == null ) {
            return null;
        }

        Contact contact1 = new Contact();

        contact1.setPhone( contact.getPhone() );
        contact1.setEmail( contact.getEmail() );

        return contact1;
    }

    protected ArrivalTime arrivalTimeToArrivalTime(com.booking.entity.ArrivalTime arrivalTime) {
        if ( arrivalTime == null ) {
            return null;
        }

        ArrivalTime arrivalTime1 = new ArrivalTime();

        if ( arrivalTime.getCheckIn() != null ) {
            arrivalTime1.setCheckIn( DateTimeFormatter.ISO_LOCAL_TIME.format( arrivalTime.getCheckIn() ) );
        }
        if ( arrivalTime.getCheckOut() != null ) {
            arrivalTime1.setCheckOut( DateTimeFormatter.ISO_LOCAL_TIME.format( arrivalTime.getCheckOut() ) );
        }

        return arrivalTime1;
    }

    protected com.booking.entity.Contact contactToContact1(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        com.booking.entity.Contact contact1 = new com.booking.entity.Contact();

        contact1.setPhone( contact.getPhone() );
        contact1.setEmail( contact.getEmail() );

        return contact1;
    }

    protected com.booking.entity.ArrivalTime arrivalTimeToArrivalTime1(ArrivalTime arrivalTime) {
        if ( arrivalTime == null ) {
            return null;
        }

        com.booking.entity.ArrivalTime arrivalTime1 = new com.booking.entity.ArrivalTime();

        if ( arrivalTime.getCheckIn() != null ) {
            arrivalTime1.setCheckIn( LocalTime.parse( arrivalTime.getCheckIn() ) );
        }
        if ( arrivalTime.getCheckOut() != null ) {
            arrivalTime1.setCheckOut( LocalTime.parse( arrivalTime.getCheckOut() ) );
        }

        return arrivalTime1;
    }

    private String hotelContactPhone(Hotel hotel) {
        com.booking.entity.Contact contact = hotel.getContact();
        if ( contact == null ) {
            return null;
        }
        return contact.getPhone();
    }
}
