package com.github.tests.personcars.rest;

import com.github.tests.personcars.dto.StatisticsDto;
import com.github.tests.personcars.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class OutputRestController {
    private final PersonService personService;

    @GetMapping("/clear")
    public ResponseEntity clearAll() {
        try {
            personService.delete();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/personwithcars")
    public ResponseEntity getPerson(@RequestParam("/personid") Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException();
            }
            if (!personService.findPersonById(id).isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(personService.findPersonById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/statistics")
    public ResponseEntity getStatistics() {
        try {
            return new ResponseEntity<>(StatisticsDto.getStatisticsDto(
                    personService.getPersonCount(),
                    personService.getCarCount(),
                    personService.getVendorCount()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
