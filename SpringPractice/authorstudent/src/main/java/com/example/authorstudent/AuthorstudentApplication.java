package com.example.authorstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AuthorstudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorstudentApplication.class, args);
    }

}
