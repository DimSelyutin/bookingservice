package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an address entity in the booking system.
 * This class is mapped to the "addresses" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "addresses")
@ToString
public class AddressEntity {

    /**
     * The unique identifier for the address.
     * This field is automatically generated using a sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_sequence", allocationSize = 1)
    private Integer id;

    /**
     * A reference to the street associated with this address.
     * This is a many-to-one relationship where multiple addresses can belong to one street.
     * The cascade type ALL means that all operations (persist, merge, remove, refresh, detach)
     * will be cascaded to the street entity.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    /**
     * The house number of the address.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private int houseNumber;

    /**
     * The postal code of the address.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String postCode;
}
