package com.booking.mapper.util;

import com.booking.entity.Street;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StreetMapper {
    @Mapping(target = "name", source = "street")
    Street toEntity(String street);
}

