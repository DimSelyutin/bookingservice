package com.booking.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.booking.exception.HotelNotFoundException;
import com.booking.facade.HotelFacade;
import com.booking.openapi.model.NewHotel;
import com.booking.util.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        newHotel = objectMapper.readValue(
                Files.readString(Paths.get(getClass().getClassLoader().getResource("./json/newHotel.json").toURI())),
                NewHotel.class
        );
    }

    @Test
    public void createHotel_ShouldReturnCreated() throws Exception {
        // Arrange
        when(hotelFacade.createHotel(newHotel)).thenReturn(TestData.createTestHotelBrief()); // Предположим, что метод createHotel возвращает созданный объект

        // Act & Assert
        mockMvc.perform(post("/api/v1/property-view/hotels")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newHotel)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(newHotel.getName()))
                .andExpect(jsonPath("$.brand").value(newHotel.getBrand()));
    }

    @Test
    @Sql(scripts = "classpath:scripts/testHotel.sql")
    public void getHotelById_ShouldReturnHotelDetail() throws Exception {
        // Arrange
        Integer hotelId = 1;
        when(hotelFacade.getHotel(hotelId)).thenReturn(TestData.createTestHotelDetails());

        // Act & Assert
        mockMvc.perform(get("/api/v1/property-view/hotels/{id}", hotelId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(hotelId))
                .andExpect(jsonPath("$.name").value(newHotel.getName()))
                .andExpect(jsonPath("$.brand").value(newHotel.getBrand()));
    }

    @Test
    public void getHotels_ShouldReturnListOfHotelBrief() throws Exception {
        // Arrange
        when(hotelFacade.getHotels(0, 10)).thenReturn(List.of(TestData.createTestHotelBrief(), TestData.createTestHotelBrief())); // Предположим, что метод getHotels возвращает список

        // Act & Assert
        mockMvc.perform(get("/api/v1/property-view/hotels")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(TestData.createTestHotelBrief().getId()))
                .andExpect(jsonPath("$[0].name").value(TestData.createTestHotelBrief().getName()));
    }

    @Test
    public void getHotelById_NotFound_ShouldReturn404() throws Exception {
        // Arrange
        Integer hotelId = 999; // Не существующий
        when(hotelFacade.getHotel(hotelId)).thenThrow(new HotelNotFoundException("Hotel with id 999 not found!"));

        // Act & Assert
        mockMvc.perform(get("/api/v1/property-view/hotels/{id}", hotelId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorCode").value(404)); // Проверка на наличие сообщения об ошибке
    }

    @Test
    public void getHotelById_InternalServerError_ShouldReturn500() throws Exception {

        // Act & Assert
        mockMvc.perform(get("/api/v1/property-view/hotels/{id}", "string"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.errorCode").value(500)); // Проверка на наличие сообщения об ошибке
    }

    @Test
    public void testSearchHotels() throws Exception {


        mockMvc.perform(get("/api/v1/property-view/hotels/search?city=Minsk&amenities=Free WiFi"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("DoubleTree by Hilton Minsk"));


    }
}
