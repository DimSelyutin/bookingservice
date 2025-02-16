package com.booking.mapper.util;

import com.booking.entity.Street;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-16T17:19:54+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class StreetMapperImpl implements StreetMapper {

    @Override
    public Street toEntity(String street) {
        if ( street == null ) {
            return null;
        }

        Street street1 = new Street();

        street1.setName( street );

        return street1;
    }
}
