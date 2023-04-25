package org.example.utils;

import org.example.models.Payment;
import org.example.models.PaymentRegistry;

import java.util.ArrayList;

public class PrepareData {

    public static double getPaymentAmount(PaymentRegistry paymentRegistry, String paymentType){
        double localPaymentAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localPaymentAmount += payment.getPaymentAmount();
            }
        }
        return localPaymentAmount;
    }

    public static double getBPA_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localBPA_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localBPA_notice += payment.getBPA_notice();
            }
        }
        return localBPA_notice;
    }

    public static double getPNKO_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localPNKO_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localPNKO_notice += payment.getPNKO_notice();
            }
        }
        return localPNKO_notice;
    }

    public static double getCashAmount(PaymentRegistry paymentRegistry, String paymentType){
        double localCashAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localCashAmount += payment.getCashAmount();
            }
        }
        return localCashAmount;
    }

    public static double getCardAmount(PaymentRegistry paymentRegistry, String paymentType){
        double localCardAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localCardAmount += payment.getCardAmount();
            }
        }
        return localCardAmount;
    }

    public static double getSBP_amount(PaymentRegistry paymentRegistry, String paymentType){
        double localSBP_amount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localSBP_amount += payment.getSBP_amount();
            }
        }
        return localSBP_amount;
    }

    public static double getOrganization_BPA_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localOrganization_BPA_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localOrganization_BPA_notice += payment.getOrganization_BPA_notice();
            }
        }
        return localOrganization_BPA_notice;
    }

    public static double getOrganization_PNKO_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localOrganization_PNKO_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().getName().equals(paymentType)){
                localOrganization_PNKO_notice += payment.getOrganization_PNKO_notice();
            }
        }
        return localOrganization_PNKO_notice;
    }

}
