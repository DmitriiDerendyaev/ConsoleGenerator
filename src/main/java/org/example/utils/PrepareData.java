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

    public double getCardAmount(PaymentRegistry paymentRegistry, String paymentType){
        double localCardAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localCardAmount += payment.getPaymentAmount();
            }
        }
        return localCardAmount;
    }

    public double getSBP_amount(PaymentRegistry paymentRegistry, String paymentType){
        double localSBP_amount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localSBP_amount += payment.getPaymentAmount();
            }
        }
        return localSBP_amount;
    }

    public double getOrganization_BPA_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localOrganization_BPA_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localOrganization_BPA_notice += payment.getPaymentAmount();
            }
        }
        return localOrganization_BPA_notice;
    }

    public double getOrganization_PNKO_notice(PaymentRegistry paymentRegistry, String paymentType){
        double localOrganization_PNKO_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            if(payment.getPaymentType().equals(paymentType)){
                localOrganization_PNKO_notice += payment.getPaymentAmount();
            }
        }
        return localOrganization_PNKO_notice;
    }

}
