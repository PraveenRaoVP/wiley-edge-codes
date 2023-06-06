package com.example.ticketbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketBookingController {
    private FareGenerator fareGenerator;

    @Autowired
    public void setFareGenerator(FareGenerator fareGenerator) {
        this.fareGenerator = fareGenerator;
    }

    @GetMapping("/fare")
    public String displayFare(Model model) {
        int fare = fareGenerator.calculateFare();
        model.addAttribute("fare", fare);
        return "fare";
    }
}

