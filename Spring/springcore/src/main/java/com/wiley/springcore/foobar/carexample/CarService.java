package com.wiley.springcore.foobar.carexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private Car myCar;

    @Autowired
    public CarService(Car myCar) {
        this.myCar = myCar;
    }
    
    public void displayCarDetails() {
        System.out.println("Make: " + myCar.getMake());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Year: " + myCar.getYear());
    }
}
