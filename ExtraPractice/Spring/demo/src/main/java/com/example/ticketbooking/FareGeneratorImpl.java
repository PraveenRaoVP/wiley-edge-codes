package com.example.ticketbooking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FareGeneratorImpl implements FareGenerator {
    @Value("${numberOfPersons}")
    private int numberOfPersons;

    @Value("${fare}")
    private int fare;


    public int calculateFare() {
        return numberOfPersons * fare;
    }

    public void setNumberOfPersons(String numberOfPersons) {
        this.numberOfPersons = Integer.parseInt(numberOfPersons);
    }

    public void setFare(String fare) {
        this.fare= Integer.parseInt(fare);
    }
}
