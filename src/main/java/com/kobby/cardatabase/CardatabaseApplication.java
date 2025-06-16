package com.kobby.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    // after adding this comment, the project should restart
    public static void main(String[] args) {

		SpringApplication.run(CardatabaseApplication.class, args);

		logger.info("CarDatabaseApplication started");
    }

}
