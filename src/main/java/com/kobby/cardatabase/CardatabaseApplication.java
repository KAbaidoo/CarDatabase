package com.kobby.cardatabase;

import com.kobby.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    // after adding this comment, the project should restart
    public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("CarDatabaseApplication started");
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner( "John", "Doe");
        Owner owner2 = new Owner("Jane", "Doe");
        Owner owner3 = new Owner( "John", "Smith");
        Owner owner4 = new Owner("Jane", "Smith");
        ownerRepository.saveAll(List.of(owner1, owner2, owner3, owner4));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "A4", "white", "ABC123", 2015, 10000, owner1));
        cars.add(new Car("BMW", "X5", "black", "DEF456", 2018, 15000, owner2));
        cars.add(new Car("Ford", "Mustang", "red", "GHI789", 2010, 20000, owner3));
        cars.add(new Car("Honda", "Civic", "blue", "JKL012", 2012, 25000, owner3));
        cars.add(new Car("Mercedes", "Benz", "green", "MNO345", 2016, 30000, owner4));
        cars.add(new Car("Nissan", "Leaf", "yellow", "PQR678", 2014, 35000, owner4));

        carRepository.saveAll(cars);

        // print all cars
        carRepository.findAll().forEach(car -> logger.info(car.toString()));

        userRepository.save(new User("user",
                "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
        userRepository.save(new User("admin",
                "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
    }
}
