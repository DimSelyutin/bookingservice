package com.booking.mapper.util;

import com.booking.entity.Country;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-19T11:28:02+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toEntity(String country) {
        if ( country == null ) {
            return null;
        }

        Country country1 = new Country();

        country1.setName( country );

        return country1;
    }
}
