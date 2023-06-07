package com.example.sbconcepts.util;


import com.example.sbconcepts.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String,Double> paymentMap = new HashMap<>();
    static{
        paymentMap.put("ac_1",9000.0);
        paymentMap.put("ac_2",12000.0);
        paymentMap.put("ac_3",6000.0);
        paymentMap.put("ac_4",4000.0);
    }
    public static boolean validateCreditLimit(String accountNumber, double paidAmount) {
        if (!paymentMap.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Invalid account number");
        }

        Double creditLimit = paymentMap.get(accountNumber);
        if (paidAmount > creditLimit) {
            throw new InsufficientAmountException("Insufficient Amount in your account");
        } else {
            return true;
        }
    }
}