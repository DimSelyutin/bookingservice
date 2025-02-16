package com.booking.controller;

import com.booking.facade.HistogramFacade;
import com.booking.openapi.api.HistogramApi;
import com.booking.openapi.model.HistogramDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Controller for operation of "/property-view/".
 */
@RestController
@Slf4j
@RequestMapping("/property-view")
@RequiredArgsConstructor
@Validated
public class HistogramController implements HistogramApi {
    private final HistogramFacade histogramFacade;

    /**
     * Getting a histogram of hotels by a given parameter.
     *
     * @param param for the histogram (for example, "city", "brand", "country", "amenities")
     * @return histogram of hotels
     */
    @Override
    @Operation(summary = "Getting a histogram of hotels by a given parameter")
    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String, Long>> getHotelHistogram(@PathVariable String param) {
        log.debug("GET-request, getHotelHistogram - start, param = {}", param);

        Map<String, Long> histogram = histogramFacade.getHotelHistogram(param);
        ResponseEntity<Map<String, Long>> response = ResponseEntity.ok(histogram);
        log.debug("GET-request, getHotelHistogram - end histogram = {}", histogram);

        return response;
    }
}
