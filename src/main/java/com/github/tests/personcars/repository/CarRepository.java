package com.github.tests.personcars.repository;

import com.github.tests.personcars.sample.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cars")
public interface CarRepository extends JpaRepository<Car, Long> {
}
