package com.github.tests.personcars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.tests.personcars.sample.Car;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {
    private Long id;
    private String model;
    private Integer horsepower;
    private Long ownerId;

    public static CarDto fromCar(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setModel(car.getVendor() + "-" + car.getModel());
        carDto.setHorsepower(car.getHorsepower());
        return carDto;
    }

    public static Car toCar(CarDto carDto) {
        if (carDto.getHorsepower() <= 0 ||
            carDto.getHorsepower() == null ||
            carDto.getOwnerId() == null ||
            carDto.getId() == null ||
            !carDto.getModel().contains("-")) {
            System.out.println("Ошибка валидации");
        }

        Car car = new Car();
        car.setId(carDto.getId());
        String[] vendorModel = carDto.getModel().split("-", 2);
        car.setVendor(vendorModel[0]);
        car.setModel(vendorModel[1]);
        car.setHorsepower(carDto.getHorsepower());
        car.setPerson_id(car.getPerson_id());
        return car;
    }
}
