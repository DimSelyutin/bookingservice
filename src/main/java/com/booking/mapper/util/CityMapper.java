package com.booking.mapper.util;

import com.booking.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {
    @Mapping(target = "name", source = "city")
    City toEntity(String city);
}

