package com.booking.repository.specification;

import com.booking.entity.Hotel;
import com.booking.entity.Address;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Join;

public class HotelSpecifications {
    public static Specification<Hotel> byCriteria(String brand, String city, String country, List<String> amenities) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Фильтрация по бренду
            if (brand != null && !brand.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
            }

            // Фильтрация по адресу (город, страна)
            Join<Hotel, Address> addressJoin = root.join("address");
            if (city != null && !city.isEmpty()) {
                predicates.add(criteriaBuilder.equal(addressJoin.get("city"), city));
            }
            if (country != null && !country.isEmpty()) {
                predicates.add(criteriaBuilder.equal(addressJoin.get("country"), country));
            }

            // Фильтрация по удобствам
            if (amenities != null && !amenities.isEmpty()) {
                // Создаем предикаты для каждого удобства
                List<Predicate> amenityPredicates = new ArrayList<>();
                for (String amenity : amenities) {
                    amenityPredicates.add(criteriaBuilder.equal(root.join("amenities").get("name"), amenity));
                }
                // Объединяем предикаты удобств с помощью OR
                predicates.add(criteriaBuilder.or(amenityPredicates.toArray(new Predicate[0])));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0])); // Объединяем все предикаты
        };

    }
}