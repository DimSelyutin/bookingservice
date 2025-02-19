package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Represents a city in the booking system.
 * This class is mapped to the "cities" table in the database.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "cities")
public class City {

    /**
     * The unique identifier for the city.
     * This field is automatically generated using a sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq", sequenceName = "city_sequence", allocationSize = 1)
    private Integer id;

    /**
     * The name of the city.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The country to which the city belongs.
     * This field is a many-to-one relationship with the Country entity.
     */
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    /**
     * A list of streets in the city.
     * This field is a one-to-many relationship with the Street entity.
     * The streets are mapped by the "city" field in the Street class.
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Street> streets;
}
