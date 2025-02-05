package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private int houseNumber;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    private String county;

    @Column(nullable = false)
    private String postCode;
}
