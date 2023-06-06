package com.example.sbconcepts.service;

import com.example.sbconcepts.model.PassengerInfo;
import com.example.sbconcepts.model.PaymentInfo;
import com.example.sbconcepts.repository.PassengerInfoRepository;
import com.example.sbconcepts.repository.PaymentInfoRepository;
import com.example.sbconcepts.request.model.FlightBookingRequest;
import com.example.sbconcepts.response.model.FlightBookingAck;
import com.example.sbconcepts.util.PaymentUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAck bookFlightTicket(FlightBookingRequest request) {
        PassengerInfo passengerInfo = request.getPassengerInfo();
        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNumber(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPid());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAck("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
