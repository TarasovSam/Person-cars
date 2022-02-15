package com.github.tests.personcars.service;

import com.github.tests.personcars.sample.Car;
import com.github.tests.personcars.sample.Person;

import java.util.Optional;

public interface PersonService {
    Person put(Person person);
    Car put(Car car);

    void delete();

    Optional<Person> findPersonById(long id);
    Optional<Car> findCarById(long id);

    Long getPersonCount();
    Long getCarCount();
    Long getVendorCount();
}
