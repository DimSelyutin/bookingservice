package com.booking.repository.specification;

import com.booking.entity.Hotel;
import com.booking.entity.AddressEntity;
import com.booking.entity.Street;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Join;

public class HotelSpecifications {

    private HotelSpecifications() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<Hotel> byCriteria(String brand, String city, String country, List<String> amenities) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (brand != null && !brand.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
            }


            // Соединение с AddressEntity
            Join<Hotel, AddressEntity> addressJoin = root.join("addressEntity");

            // Соединение с полем street
            Join<AddressEntity, Street> streetJoin = addressJoin.join("street");



            // Фильтрация по городу
            if (city != null && !city.isEmpty()) {
                predicates.add(criteriaBuilder.equal(streetJoin.get("city").get("name"), city));
            }

            // Фильтрация по стране
            if (country != null && !country.isEmpty()) {
                predicates.add(criteriaBuilder.equal(streetJoin.get("country").get("name"), country));
            }

            if (amenities != null && !amenities.isEmpty()) {

                List<Predicate> amenityPredicates = new ArrayList<>();
                for (String amenity : amenities) {
                    amenityPredicates.add(criteriaBuilder.equal(root.join("amenities").get("name"), amenity));
                }

                predicates.add(criteriaBuilder.or(amenityPredicates.toArray(new Predicate[0])));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}