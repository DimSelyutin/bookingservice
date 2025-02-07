package com.booking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.booking.exception.HotelNotFoundException;
import com.booking.facade.HotelFacade;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HotelFacade hotelFacade;

    @InjectMocks
    private HotelController hotelController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenGetHotelById_thenReturnHotelDetail() {
        // Given
        Integer hotelId = 1;
        HotelDetail hotelDetail = new HotelDetail();
        hotelDetail.setId(hotelId);
        hotelDetail.setName("Test Hotel");

        when(hotelFacade.getHotel(hotelId)).thenReturn(hotelDetail);

        // When
        ResponseEntity<HotelDetail> response = hotelController.getHotelById(hotelId);

        // Then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(hotelDetail, response.getBody());
    }

    @Test
    public void whenGetHotels_thenReturnListOfHotelBrief() {
        // Given
        HotelBrief brief = new HotelBrief();
        brief.setId(2);
        brief.setName("Hotel Brief 2");

        List<HotelBrief> hotelBriefs = Arrays.asList(brief, brief);
        when(hotelFacade.getHotels(0, 10)).thenReturn(hotelBriefs);

        // When
        ResponseEntity<List<HotelBrief>> response = hotelController.getHotels(0, 10);

        // Then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(hotelBriefs, response.getBody());
    }

    @Test
    public void whenGetHotelById_notFound_thenReturn404() throws Exception {
        // Given
        Integer hotelId = 999; // Не существующий ID
        when(hotelFacade.getHotel(hotelId)).thenThrow(new HotelNotFoundException("Hotel not found!"));

        // When & Then
        mockMvc.perform(get("/api/v1/property-view/hotels/{id}", hotelId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void whenGetHotelById_internalServerError_thenReturn500() throws Exception {
        // Given
        Integer hotelId = 1;
        when(hotelFacade.getHotel(hotelId)).thenThrow(new RuntimeException("Internal Server Error"));

        // When & Then
        mockMvc.perform(get("/api/v1/property-view/hotels/{id}", "hotelId"))
                .andExpect(status().isInternalServerError());
    }


}
