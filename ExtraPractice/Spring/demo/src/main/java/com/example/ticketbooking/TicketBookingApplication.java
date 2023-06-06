package com.example.ticketbooking;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TicketBookingApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/ticketbooking/beans.xml");

    }
}
