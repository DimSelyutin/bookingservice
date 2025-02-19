package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a street in the booking system.
 * This class is mapped to the "streets" table in the database.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "streets")
public class Street {

    /**
     * The unique identifier for the street.
     * This field is automatically generated using a sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_seq")
    @SequenceGenerator(name = "street_seq", sequenceName = "street_sequence", allocationSize = 1)
    private Integer id;

    /**
     * The name of the street.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The city to which the street belongs.
     * This field is a many-to-one relationship with the City entity.
     */
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
