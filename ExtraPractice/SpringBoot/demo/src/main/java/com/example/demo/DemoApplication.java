package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    private FareGenerator fareGenerator;

    @Autowired
    public void setFareGenerator(FareGenerator fareGenerator) {
        this.fareGenerator = fareGenerator;
    }

    public int displayFare() {
        return fareGenerator.calculateFare();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
