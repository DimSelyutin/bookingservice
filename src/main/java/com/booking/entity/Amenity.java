package com.booking.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents an amenity that a hotel can provide.
 * This class is mapped to the "amenities" table in the database.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "amenities")
public class Amenity {

    /**
     * The unique identifier for the amenity.
     * This field is automatically generated using the identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The name of the amenity.
     * This field cannot be null and must be unique across all amenities.
     */
    @Column(nullable = false, unique = true)
    private String name;
}
