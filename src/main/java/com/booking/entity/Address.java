package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int houseNumber;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    private String country;

    @Column(nullable = false)
    private String postCode;
}
