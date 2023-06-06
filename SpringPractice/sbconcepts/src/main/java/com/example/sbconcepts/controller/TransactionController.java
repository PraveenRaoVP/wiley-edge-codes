package com.example.sbconcepts.controller;

import com.example.sbconcepts.request.model.FlightBookingRequest;
import com.example.sbconcepts.response.model.FlightBookingAck;
import com.example.sbconcepts.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value="/api/v1")
@RestController
public class TransactionController {

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping("/bookFlightTicket")
    public FlightBookingAck bookFlightTicket(@RequestBody FlightBookingRequest request) {
        return flightBookingService.bookFlightTicket(request);

    }
}
