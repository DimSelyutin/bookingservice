package com.booking.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.booking.exception.HotelNotFoundException;
import com.booking.facade.HotelFacade;
import com.booking.openapi.model.HotelSearchCriteriaDTO;
import com.booking.openapi.model.NewHotel;
import com.booking.util.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;
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

    @Autowired
    private ObjectMapper objectMapper;

    private NewHotel newHotel;

    private static final String API_URL = "/api/v1/property-view/hotels";

    @BeforeEach
    public void setUp() throws Exception {
        newHotel = objectMapper.readValue(
                Files.readString(Paths.get(getClass().getClassLoader().getResource("./json/newHotel.json").toURI())),
                NewHotel.class
        );
    }


    @Test
    public void createHotel_ShouldReturnCreated() throws Exception {
        when(hotelFacade.createHotel(newHotel)).thenReturn(TestData.createTestHotelBrief());

        mockMvc.perform(post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newHotel)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(newHotel.getName()))
                .andExpect(jsonPath("$.brand").value(newHotel.getBrand()));
    }

    @Test
    public void getHotelById_ShouldReturnHotelDetail() throws Exception {
        Integer hotelId = 1;
        when(hotelFacade.getHotel(hotelId)).thenReturn(TestData.createTestHotelDetails());

        mockMvc.perform(get(API_URL + "/{id}", hotelId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(hotelId))
                .andExpect(jsonPath("$.name").value(newHotel.getName()))
                .andExpect(jsonPath("$.brand").value(newHotel.getBrand()));
    }

    @Test
    public void getHotels_ShouldReturnListOfHotelBrief() throws Exception {
        when(hotelFacade.getHotels(0, 10)).thenReturn(List.of(TestData.createTestHotelBrief(), TestData.createTestHotelBrief()));

        mockMvc.perform(get(API_URL)
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(TestData.createTestHotelBrief().getId()))
                .andExpect(jsonPath("$[0].name").value(TestData.createTestHotelBrief().getName()));
    }

    @Test
    public void getHotelById_NotFound_ShouldReturn404() throws Exception {
        Integer hotelId = 999;
        when(hotelFacade.getHotel(hotelId)).thenThrow(new HotelNotFoundException("Hotel with id 999 not found!"));

        mockMvc.perform(get(API_URL + "/{id}", hotelId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorCode").value(404));
    }

    @Test
    public void getHotelById_InternalServerError_ShouldReturn500() throws Exception {
        mockMvc.perform(get(API_URL + "/{id}", "string"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.errorCode").value(500));
    }

    @Test
    public void testSearchHotels() throws Exception {

        when(hotelFacade.searchHotels(any(HotelSearchCriteriaDTO.class)))
                .thenReturn(List.of(TestData.createTestHotelBrief()));

        mockMvc.perform(get(API_URL + "/search?city=Minsk&amenities=Free WiFi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(TestData.createTestHotelBrief().getId()))
                .andExpect(jsonPath("$[0].name").value("DoubleTree by Hilton Minsk"));
    }

    @Test
    void addAmenitiesToHotel_ShouldReturnNoContent() throws Exception {
        Integer hotelId = 1;
        List<String> amenities = Arrays.asList("Free WiFi", "Swimming Pool");
        String jsonContent = objectMapper.writeValueAsString(amenities);

        mockMvc.perform(post(API_URL + "/{id}/amenities", hotelId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetHotelHistogramCity() throws Exception {
        // Выполнение GET-запроса
        mockMvc.perform(get(API_URL + "/histogram/city") // Замените на ваш URL
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Minsk").value(1));
    }

    @Test
    public void testGetHotelHistogramAmenities() throws Exception {
        // Выполнение GET-запроса
        mockMvc.perform(get(API_URL + "/histogram/amenities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.['Free WiFi']").value(1));
    }

}

