package com.booking.controller;

import com.booking.entity.util.HotelDetailsDto;
import com.booking.exception.HotelNotFoundException;
import com.booking.facade.HotelFacade;
import com.booking.openapi.api.PropertyViewApi;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.NewHotel;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Контроллер для работы "/property-view/hotels/".
 */
@RestController
@Slf4j
@RequestMapping("api/v1/property-view/hotels")
@RequiredArgsConstructor
@Validated
public class HotelController implements PropertyViewApi {


    private final HotelFacade hotelFacade;

    /**
     * Getting extended information on a specific hotel.
     *
     * @param id account ID
     * @return DTO account balance
     */
    @Override
    @Operation(summary = "The method of obtaining additional information about the hotel")
    @GetMapping("/{id}")
    public ResponseEntity<HotelDetail> getHotelById(@PathVariable("id") Integer id) {
        log.debug("GET-request, getHotelById - start, hotel id = {}", id);

        ResponseEntity<HotelDetail> response = ResponseEntity.ok(hotelFacade.getHotel(id));
        log.debug("GET-request, getHotelById - end, response = {}", response);
        return response;

    }

    /**
     * Getting a list of hotels.
     *
     * @param page page number
     * @param size page size
     * @* @return list of hotels
     */
    @Override
    @Operation(summary = "Метод получения списка гостиниц")
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelBrief>> getHotels(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        log.debug("GET-request, getHotels - start, page = {}, size = {}", page, size);
        List<HotelBrief> hotelBriefs = hotelFacade.getHotels(page, size);
        ResponseEntity<List<HotelBrief>> response = ResponseEntity.ok(hotelBriefs);
        log.debug("GET-request, getHotels - end, size = {}", hotelBriefs.size());

        return response;
    }

    /**
     * Создание нового отеля.
     *
     * @param newHotel DTO с данными нового отеля
     * @return DTO нового отеля
     */
    @Operation(summary = "Создание нового отеля")
    @PostMapping
    public ResponseEntity<HotelBrief> createHotel(@RequestBody NewHotel newHotel) {
        log.debug("POST-request, createHotel - start, hotel = {}", newHotel);

        HotelBrief hotelBrief = hotelFacade.createHotel(newHotel);
        log.debug("POST-request, createHotel - end, response = {}", hotelBrief);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelBrief);
    }
}
