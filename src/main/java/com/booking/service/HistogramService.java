package com.booking.service;

import java.util.Map;

/**
 * Service interface for generating histograms based on input parameters.
 * This interface defines methods for creating a histogram representation
 * of data associated with a specific parameter.
 */
public interface HistogramService {

    /**
     * Generates a histogram based on the provided parameter.
     *
     * @param param the input parameter for which the histogram will be generated.
     *              Must not be null or empty.
     * @return a Map where the keys are categories represented by the parameter,
     * and the values are the corresponding counts for each category.
     */
    Map<String, Integer> generateHistogram(String param);
}
