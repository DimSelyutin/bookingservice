package com.booking.facade;

import java.util.Map;

public interface HistogramFacade {

    /**
     * Getting a histogram of hotels by a given parameter.
     *
     * @param parameter for the histogram (for example, "city", "brand", "county", "amenities")
     * @return histogram of hotels
     */
    Map<String, Long> getHotelHistogram(String parameter);

}
