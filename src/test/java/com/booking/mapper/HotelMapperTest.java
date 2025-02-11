package com.booking.mapper;

import com.booking.entity.Hotel;
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

public class HotelMapperTest {

    private HotelMapper hotelMapper;

    @BeforeEach
    public void setUp() {
        hotelMapper = Mappers.getMapper(HotelMapper.class);
    }

    @Test
    public void whenValidHotel_thenHotelDetailShouldBeMapped() {

        Hotel hotel = createSingleTestHotel();
        hotel.setAddress(null);
        HotelDetail dto = hotelMapper.toHotelDetailsDto(hotel);

        assertEquals(hotel.getId(), dto.getId());
        assertEquals(hotel.getName(), dto.getName());
        assertNull(dto.getAddress());
        assertNull(dto.getContacts());
    }

    @Test
    public void whenNullHotel_thenHotelDetailShouldBeNull() {
        HotelDetail dto = hotelMapper.toHotelDetailsDto(null);
        assertNull(dto);
    }

    @Test
    public void whenListOfHotels_thenHotelBriefsShouldBeMapped() {
        // Given
        List<Hotel> hotels = createTestHotels(); // Используем метод из TestData
        String fullAddress = "9 Pobediteley Avenue, Minsk, 220004";

        // When
        List<HotelBrief> dtos = hotelMapper.toHotelBriefDtos(hotels);

        // Then
        assertEquals(2, dtos.size());
        assertEquals(hotels.get(0).getId(), dtos.get(0).getId());
        assertEquals(hotels.get(0).getName(), dtos.get(0).getName());
        assertEquals(fullAddress, dtos.get(0).getAddress());
        assertEquals(hotels.get(1).getId(), dtos.get(1).getId());
        assertEquals(hotels.get(1).getName(), dtos.get(1).getName());
    }

    @Test
    public void whenValidHotel_thenHotelBriefShouldBeMapped() {
        // Упрощаем создание отеля с помощью TestData
        Hotel hotel = createSingleTestHotel();

        HotelBrief dto = hotelMapper.toHotelBriefDto(hotel);

        assertEquals(hotel.getId(), dto.getId());
        assertEquals(hotel.getName(), dto.getName());
    }

    @Test
    public void whenNullHotel_thenHotelBriefShouldBeNull() {
        HotelBrief dto = hotelMapper.toHotelBriefDto(null);
        assertNull(dto);
    }
}
