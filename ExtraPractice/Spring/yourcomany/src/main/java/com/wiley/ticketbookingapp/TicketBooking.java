package com.wiley.ticketbookingapp;

public class TicketBooking {
    private int numberOfPersons;
    private double fare;

    // Setter methods for dependency injection
    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double calculateTotalFare() {
        return numberOfPersons * fare;
    }

    public void displayFare() {
        System.out.println("Total fare for booking " + numberOfPersons + " tickets: " + calculateTotalFare());
    }
}
