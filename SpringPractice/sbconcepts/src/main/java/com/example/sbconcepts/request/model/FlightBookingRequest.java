package com.example.sbconcepts.request.model;

import com.example.sbconcepts.model.PassengerInfo;
import com.example.sbconcepts.model.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;

}
