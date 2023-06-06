package com.example.sbconcepts.util;


import com.example.sbconcepts.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String, Double> paymentMap = new HashMap<>();

    static{
        paymentMap.put("ac1", 123000.00);
        paymentMap.put("ac2", 12300.00);
        paymentMap.put("ac3", 23000.00);
        paymentMap.put("ac4", 1200.00);
    }

    public static boolean validateCreditLimit(String accountNumber, double paidAmount) {
        if(paidAmount > paymentMap.get(accountNumber)){
            throw new InsufficientAmountException("Insufficient Amount in your account");
        } else
        return true;
    }
}
