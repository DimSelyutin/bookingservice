package com.booking.mapper.util;

import com.booking.entity.City;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-19T11:28:02+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CityMapperImpl implements CityMapper {

    @Override
    public City toEntity(String city) {
        if ( city == null ) {
            return null;
        }

        City city1 = new City();

        city1.setName( city );

        return city1;
    }
}
