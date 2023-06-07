package com.example.appointmentauthor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AppointmentauthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentauthorApplication.class, args);
    }

}
