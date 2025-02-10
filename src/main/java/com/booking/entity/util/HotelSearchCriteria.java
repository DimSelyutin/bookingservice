package com.booking.entity.util;

import com.booking.entity.Amenity;
import lombok.*;

import java.util.List;

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
