package com.booking.facade.impl;

import com.booking.entity.util.HotelCountDTO;
import com.booking.facade.HistogramFacade;
import com.booking.mapper.HotelMapper;
import com.booking.service.HistogramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Facade for Histogram.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class HistogramFacadeImpl implements HistogramFacade {

    private final HistogramService histogramService;
    private final HotelMapper hotelMapper;

    /**
     * {@inheritDoc}
     */
    public Map<String, Long> getHotelHistogram(String param) {

        List<HotelCountDTO> hotelCountDTO = histogramService.generateHistogram(param);

        return hotelCountDTO.stream().collect(Collectors.toMap(
                HotelCountDTO::getName,
                HotelCountDTO::getCount));
    }
}
