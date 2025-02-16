package com.booking.controller;

import com.booking.facade.HotelFacade;
import com.booking.openapi.api.SearchApi;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelSearchCriteriaDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for operation of "/property-view/".
 */
@RestController
@Slf4j
@RequestMapping("/property-view")
@RequiredArgsConstructor
@Validated
public class SearchController implements SearchApi {
    private final HotelFacade hotelFacade;

    /**
     * Search for a hotel by filters.
     *
     * @param criteriaDTO DTO with filters
     * @* @return DTO of the found hotel
     */
    @Override
    @Operation(summary = "The method of searching for hotels by criteria")
    @GetMapping("/hotels/search")

    public ResponseEntity<List<HotelBrief>> searchHotels(@ModelAttribute HotelSearchCriteriaDTO criteriaDTO) {
        log.debug("GET-request, searchHotels - start, criteria = {}", criteriaDTO);

        List<HotelBrief> hotelBriefs = hotelFacade.searchHotels(criteriaDTO);
        ResponseEntity<List<HotelBrief>> response = ResponseEntity.ok(hotelBriefs);
        log.debug("GET-request, searchHotels - end, size = {}", hotelBriefs.size());

        return response;
    }
}
