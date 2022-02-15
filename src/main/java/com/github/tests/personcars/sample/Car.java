package com.github.tests.personcars.sample;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    private Long id;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "model")
    private String model;

    @Column(name = "horsepower")
    private Integer horsepower;

    @JoinColumn(name = "person_id", nullable = false)
    private Long person_id;
}
