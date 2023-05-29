package com.wiley.springcore.foobar.carexample;

public class Car {
    private String make;
    private String model;
    private int year;

    private Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Factory method to create an instance of Car
    public static Car createInstance(String make, String model, int year) {
        return new Car(make, model, year);
    }
}

