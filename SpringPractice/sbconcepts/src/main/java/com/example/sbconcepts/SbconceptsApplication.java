package com.example.sbconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SbconceptsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbconceptsApplication.class, args);
    }

}
