package com.github.tests.personcars.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class AgeCalculator {
    public static int calculate(Date birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
