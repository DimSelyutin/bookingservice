package com.booking.service.impl;

import com.booking.entity.Hotel;
import com.booking.exception.HotelNotFoundException;
import com.booking.repository.HotelRepository;
import com.booking.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HotelServiceImplTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Test
    public void whenHotelExists_thenReturnHotel() {
        // Given
        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setName("Hotel Test");

        // Имитация поведения репозитория
        when(hotelRepository.findById(1)).thenReturn(Optional.of(hotel));

        // When
        Hotel foundHotel = hotelService.getHotel(1);

        // Then
        assertEquals(hotel.getId(), foundHotel.getId());
        assertEquals(hotel.getName(), foundHotel.getName());
    }

    @Test
    public void whenHotelDoesNotExist_thenThrowHotelNotFoundException() {
        // Given
        Integer hotelId = 1;

        // Имитация поведения репозитория
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        // When / Then
        HotelNotFoundException exception = assertThrows(HotelNotFoundException.class, () -> {
            hotelService.getHotel(hotelId);
        });

        assertEquals("Hotel with id 1 not found!", exception.getMessage());
    }


}
