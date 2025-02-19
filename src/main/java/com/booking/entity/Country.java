package com.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Represents a country entity in the booking system.
 * This class is mapped to the "countries" table in the database.
 */
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "countries")
public class Country {

    /**
     * The unique identifier for the country.
     * This field is automatically generated using a sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "country_sequence", allocationSize = 1)
    private Integer id;

    /**
     * The name of the country.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * A list of cities that belong to this country.
     * This is a one-to-many relationship where one country can have multiple cities.
     * The 'mappedBy' attribute indicates that the 'country' field in the City class owns the relationship.
     * The cascade type ALL means that all operations (persist, merge, remove, refresh, detach)
     * will be cascaded to the cities.
     */
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;
}
