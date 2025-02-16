package com.booking.mapper;

import com.booking.entity.Hotel;
import com.booking.mapper.util.AddressMapper;
import com.booking.mapper.util.CityMapper;
import com.booking.mapper.util.CountryMapper;
import com.booking.mapper.util.StreetMapper;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static com.booking.util.TestData.createSingleTestHotel;
import static com.booking.util.TestData.createTestHotels;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HotelMapperTest {

    private HotelMapper hotelMapper;

    private AddressMapper addressMapper;

    @BeforeEach
    public void setUp() {
        addressMapper = Mappers.getMapper(AddressMapper.class);
        hotelMapper = new HotelMapperImpl(addressMapper);
    }

    @Test
    void whenValidHotel_thenHotelDetailShouldBeMapped() {

        Hotel hotel = createSingleTestHotel();
        hotel.setAddressEntity(null);
        HotelDetail dto = hotelMapper.toHotelDetailsDto(hotel);

        assertEquals(hotel.getId(), dto.getId());
        assertEquals(hotel.getName(), dto.getName());
        assertNull(dto.getAddress());
        assertNull(dto.getContacts());
    }

    @Test
    void whenNullHotel_thenHotelDetailShouldBeNull() {
        HotelDetail dto = hotelMapper.toHotelDetailsDto(null);
        assertNull(dto);
    }

    @Test
    void whenListOfHotels_thenHotelBriefsShouldBeMapped() {
        // Given
        List<Hotel> hotels = createTestHotels();
        String fullAddress = "9 Main St, New York, 10001, USA";

        // When
        List<HotelBrief> dtos = hotelMapper.toHotelBriefDtos(hotels);

        // Then
        assertEquals(3, dtos.size());
        assertEquals(hotels.get(0).getId(), dtos.get(0).getId());
        assertEquals(hotels.get(0).getName(), dtos.get(0).getName());
        assertEquals(fullAddress, dtos.get(0).getAddress());
        assertEquals(hotels.get(1).getId(), dtos.get(1).getId());
        assertEquals(hotels.get(1).getName(), dtos.get(1).getName());
    }

    @Test
    void whenValidHotel_thenHotelBriefShouldBeMapped() {
        // Упрощаем создание отеля с помощью TestData
        Hotel hotel = createSingleTestHotel();

        HotelBrief dto = hotelMapper.toHotelBriefDto(hotel);

        assertEquals(hotel.getId(), dto.getId());
        assertEquals(hotel.getName(), dto.getName());
    }

    @Test
    void whenNullHotel_thenHotelBriefShouldBeNull() {
        HotelBrief dto = hotelMapper.toHotelBriefDto(null);
        assertNull(dto);
    }
}
