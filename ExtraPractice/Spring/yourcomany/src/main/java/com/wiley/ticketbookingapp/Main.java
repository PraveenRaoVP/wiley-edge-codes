package com.wiley.ticketbookingapp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        // Create Bean Factory
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        // Get the TicketBooking bean from the Bean Factory
        TicketBooking ticketBooking = (TicketBooking) beanFactory.getBean("TicketBooking");

        // Call the faregenerator and display method
        ticketBooking.displayFare();
    }
}

