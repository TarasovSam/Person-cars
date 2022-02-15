package com.github.tests.personcars.rest;

import com.github.tests.personcars.dto.CarDto;
import com.github.tests.personcars.dto.PersonDto;
import com.github.tests.personcars.service.AgeCalculator;
import com.github.tests.personcars.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class InputRestController {
    private final PersonService personService;

    @PostMapping("/car")
    public ResponseEntity addCar(@RequestBody CarDto carDto) {
        Map<Object, Object> responce = new HashMap<>();
        try {
            if (personService.findCarById(carDto.getId()).isPresent() ||
                AgeCalculator.calculate(PersonDto.fromPerson(personService.findPersonById(carDto.getOwnerId()).get()).getBirthdate()) < 18) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            responce.put("car", personService.put(CarDto.toCar(carDto)));
            return ResponseEntity.ok(responce);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/person")
    public ResponseEntity addPerson(@RequestBody PersonDto personDto) {
        Map<Object, Object> responce = new HashMap<>();
        try {
            if (personService.findPersonById(personDto.getId()).isPresent()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            responce.put("person", personService.put(PersonDto.toPerson(personDto)));
            return ResponseEntity.ok(responce);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
