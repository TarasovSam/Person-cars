package com.github.tests.personcars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.tests.personcars.sample.Person;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date birthdate;

    public static PersonDto fromPerson(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setBirthdate(person.getBirthdate());
        return personDto;
    }

    public static Person toPerson(PersonDto personDto) {
        if (personDto.getBirthdate().after(new Date()) ||
            personDto.getName() == null ||
            personDto.getId() == null) {
            log.warn("Person");
            System.out.println("Ошибка валидации");
        }

        Person person = new Person();
        person.setId(personDto.getId());
        person.setName(personDto.getName());
        person.setBirthdate(personDto.getBirthdate());
        return person;
    }
}
