package com.github.tests.personcars.sample;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persons")
@Data
public class Person {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private Date birthdate;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL)
    private List<Car> cars;
}
