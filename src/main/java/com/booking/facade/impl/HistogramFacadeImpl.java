package com.booking.facade.impl;

//import com.booking.enums.HistogramParam;

import com.booking.facade.HistogramFacade;
import com.booking.service.HistogramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Facade for Histogram.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class HistogramFacadeImpl implements HistogramFacade {

    private final HistogramService histogramService;

    /**
     * {@inheritDoc}
     */
    public Map<String, Integer> getHotelHistogram(String param) {
        return histogramService.generateHistogram(param);
    }
}
