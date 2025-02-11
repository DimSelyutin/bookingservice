package com.booking.entity.util;
import lombok.*;

import java.util.List;

/**
 * The class representing the search criteria.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelSearchCriteria {

    private String name;
    private String brand;
    private String city;
    private String country;
    private List<String> amenities;


}
