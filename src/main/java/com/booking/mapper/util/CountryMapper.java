package com.booking.mapper.util;

import com.booking.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "name", source = "country")
    Country toEntity(String country);
}
