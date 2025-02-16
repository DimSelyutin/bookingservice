package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "streets")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_seq")
    @SequenceGenerator(name = "street_seq", sequenceName = "street_sequence", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
