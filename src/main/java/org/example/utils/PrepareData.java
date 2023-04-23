package org.example.utils;

import org.example.models.Payment;
import org.example.models.PaymentRegistry;

import java.util.ArrayList;

public class PrepareData {

    public double getPaymentAmount(PaymentRegistry paymentRegistry, String paymentType){
        double localPaymentAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localPaymentAmount += payment.getPaymentAmount();
            }
        }
        return localPaymentAmount;
    }

    public double getBPA_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localBPA_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localBPA_notice += payment.getPaymentAmount();
            }
        }
        return localBPA_notice;
    }

    public double getPNKO_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localPNKO_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localPNKO_notice += payment.getPaymentAmount();
            }
        }
        return localPNKO_notice;
    }

    public double getСashAmount(PaymentRegistry paymentRegistry, String paymentType){
        double localСashAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localСashAmount += payment.getPaymentAmount();
            }
        }
        return localСashAmount;
    }


}
