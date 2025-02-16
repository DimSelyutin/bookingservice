package com.booking.service.impl;

import com.booking.entity.util.HotelCountDTO;
import com.booking.enums.HistogramParam;
import com.booking.repository.HistogramRepository;
import com.booking.service.HistogramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for managing histograms.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class HistogramServiceImpl implements HistogramService {

    private final HistogramRepository histogramRepository;

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public List<HotelCountDTO> generateHistogram(String param) {
        log.info("Starting histogram generation for parameter: {}", param);

        HistogramParam histogramParam;
        try {
            histogramParam = HistogramParam.fromString(param);
            log.debug("Parsed HistogramParam: {}", histogramParam);
        } catch (IllegalArgumentException e) {
            log.error("Invalid parameter provided: {}", param, e);
            throw e; // Можно выбросить исключение или вернуть значение по умолчанию
        }

        return histogramParam.getMethod(histogramRepository);


    }
}
