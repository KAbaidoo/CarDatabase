package com.kobby.cardatabase.web;

import com.kobby.cardatabase.domain.Car;
import com.kobby.cardatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public Iterable<Car> getCars(){
        // Fetch and return cars
        return carRepository.findAll();
    }
}
