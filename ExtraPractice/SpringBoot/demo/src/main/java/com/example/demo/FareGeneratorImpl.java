package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FareGeneratorImpl implements FareGenerator {
    @Value("${numberOfPersons}")
    private int numberOfPersons;

    @Value("${fare}")
    private int fare;

    @Override
    public int calculateFare() {
        return numberOfPersons * fare;
    }
}
