package com.booking.controller;

import com.booking.facade.AmenityFacade;
import com.booking.facade.HistogramFacade;
import com.booking.facade.HotelFacade;
import com.booking.openapi.api.PropertyViewApi;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.HotelSearchCriteriaDTO;
import com.booking.openapi.model.NewHotel;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Controller for operation of "/property-view/hotels/".
 */
@RestController
@Slf4j
@RequestMapping("property-view/hotels")
@RequiredArgsConstructor
@Validated
public class HotelController implements PropertyViewApi {

    private final HotelFacade hotelFacade;
    private final AmenityFacade amenityFacade;
    private final HistogramFacade histogramFacade;

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
        log.info("GET-request, getHotelById - end, response = {}", response);
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
    @GetMapping()
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
     * Creation of a new hotel.
     *
     * @return DTO of the new hotel
     * @* @param newHotel DTO with new hotel data
     */
    @Operation(summary = "Creation of a new hotel")
    @PostMapping
    public ResponseEntity<HotelBrief> createHotel(@RequestBody NewHotel newHotel) {
        log.debug("POST-request, createHotel - start, hotel = {}", newHotel);

        HotelBrief hotelBrief = hotelFacade.createHotel(newHotel);
        log.debug("POST-request, createHotel - end, response = {}", hotelBrief);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelBrief);
    }

    /**
     * Search for a hotel by filters.
     *
     * @param criteriaDTO DTO with filters
     * @* @return DTO of the found hotel
     */
    @Operation(summary = "The method of searching for hotels by criteria")
    @GetMapping("/search")
    public ResponseEntity<List<HotelBrief>> searchHotels(@ModelAttribute HotelSearchCriteriaDTO criteriaDTO) {
        log.debug("GET-request, searchHotels - start, criteria = {}", criteriaDTO);

        List<HotelBrief> hotelBriefs = hotelFacade.searchHotels(criteriaDTO);
        ResponseEntity<List<HotelBrief>> response = ResponseEntity.ok(hotelBriefs);
        log.debug("GET-request, searchHotels - end, size = {}", hotelBriefs.size());

        return response;
    }

    /**
     * @param id
     * @param amenities
     * @return
     */
    @Operation(summary = "Adding amenities to the hotel")
    @PostMapping("/{id}/amenities")
    public ResponseEntity<Void> addAmenitiesToHotel(@PathVariable Integer id, @RequestBody List<String> amenities) {
        log.debug("POST-request, addAmenitiesToHotel - start, hotelId = {}, amenities = {}", id, amenities);

        amenityFacade.addAmenitiesToHotel(id, amenities);

        log.debug("POST-request, addAmenitiesToHotel - end, hotelId = {}", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Getting a histogram of hotels by a given parameter.
     *
     * @param parameter for the histogram (for example, "city", "brand", "country", "amenities")
     * @return histogram of hotels
     */
    @Override
    @Operation(summary = "Getting a histogram of hotels by a given parameter")
    @GetMapping("/histogram/{parameter}")
    public ResponseEntity<Map<String, Integer>> getHotelHistogram(@PathVariable String parameter) {
        log.debug("GET-request, getHotelHistogram - start, param = {}", parameter);

        Map<String, Integer> histogram = histogramFacade.getHotelHistogram(parameter);
        ResponseEntity<Map<String, Integer>> response = ResponseEntity.ok(histogram);
        log.debug("GET-request, getHotelHistogram - end, histogram size = {}", histogram.size());

        return response;
    }
}
