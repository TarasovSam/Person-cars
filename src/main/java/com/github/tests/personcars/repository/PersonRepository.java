package com.github.tests.personcars.repository;

import com.github.tests.personcars.sample.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("persons")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
