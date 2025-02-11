package com.booking.service.impl;

import com.booking.enums.HistogramParam;
import com.booking.repository.HistogramRepository;
import com.booking.service.HistogramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service for managing histograms.
 */
@RequiredArgsConstructor
@Service
public class HistogramServiceImpl implements HistogramService {

    private final HistogramRepository histogramRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Integer> generateHistogram(String param) {

        HistogramParam histogramParam = HistogramParam.fromString(param);
        Map<String, Integer> list = histogramParam.getMethod(histogramRepository);

        return list;
    }
}
