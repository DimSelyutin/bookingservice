package com.booking.enums;

import com.booking.repository.HistogramRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Enum representing the parameters for generating histograms
 * related to hotel statistics, such as city, brand, country,
 * and amenities.
 */
@Slf4j
@Getter
public enum HistogramParam {

    CITY("city"),
    BRAND("brand"),
    COUNTRY("country"),
    AMENITIES("amenities");

    private final String name;

    /**
     * Constructor for HistogramParam enum.
     *
     * @param name the name of the histogram parameter.
     */
    HistogramParam(String name) {
        this.name = name;
    }

    /**
     * Executes the method corresponding to the histogram parameter
     * and retrieves the count of hotels based on the selected parameter.
     *
     * @param repository the HistogramRepository used to fetch data.
     * @return a map containing the results of the count,
     * where the key is the parameter value and the value is the count.
     */
    public Map<String, Integer> getMethod(HistogramRepository repository) {
        log.info("Executing method for parameter: {}", this.name);

        Map<String, Integer> result = switch (this) {
            case CITY -> mapResultsToMap(repository.countHotelsByCity());
            case BRAND -> mapResultsToMap(repository.countHotelsByBrand());
            case COUNTRY -> mapResultsToMap(repository.countHotelsByCountry());
            case AMENITIES -> mapResultsToMap(repository.countHotelsByAmenities());
            default -> throw new UnsupportedOperationException("Unknown parameter: " + name);
        };

        log.info("Result for parameter {}: {}", this.name, result);
        return result;
    }

    /**
     * Converts a string representation of a histogram parameter
     * to its corresponding HistogramParam enum value.
     *
     * @param param the string representation of the parameter.
     * @return the corresponding HistogramParam enum value.
     * @throws IllegalArgumentException if the provided parameter is invalid.
     */
    public static HistogramParam fromString(String param) {
        try {
            return HistogramParam.valueOf(param.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.error("Invalid parameter: {}", param, e);
            throw new IllegalArgumentException("Invalid parameter: " + param);
        }
    }

    /**
     * Maps the results from the repository to a map format.
     *
     * @param results the list of results returned from the repository.
     * @return a map where the key is the parameter value (e.g., city)
     * and the value is the corresponding count of hotels.
     */
    public Map<String, Integer> mapResultsToMap(List<Object[]> results) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (Object[] result : results) {
            String city = (String) result[0];
            Long count = (Long) result[1];
            resultMap.put(city, count.intValue());
        }
        return resultMap;
    }
}
