package org.example.utils;

import org.example.models.Payment;
import org.example.models.PaymentRegistry;

import java.util.ArrayList;

public class PrepareData {

    public static double getTotalPaymentAmount(PaymentRegistry paymentRegistry){
        double totalPaymentAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalPaymentAmount += payment.getPaymentAmount();
        }
        return totalPaymentAmount;
    }

    public static double getTotalBPA_notice(PaymentRegistry paymentRegistry){
        double totalBPA_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalBPA_notice += payment.getBPA_notice();
        }
        return totalBPA_notice;
    }

    public static double getTotalPNKO_notice(PaymentRegistry paymentRegistry){
        double totalPNKO_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalPNKO_notice += payment.getPNKO_notice();
        }
        return totalPNKO_notice;
    }

    public static double getTotalCashAmount(PaymentRegistry paymentRegistry){
        double totalCashAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalCashAmount += payment.getCashAmount();
        }
        return totalCashAmount;
    }

    public static double getTotalCardAmount(PaymentRegistry paymentRegistry){
        double totalCardAmount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalCardAmount += payment.getCardAmount();
        }
        return totalCardAmount;
    }

    public static double getTotalSBP_amount(PaymentRegistry paymentRegistry){
        double totalSBP_amount = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalSBP_amount += payment.getSBP_amount();
        }
        return totalSBP_amount;
    }

    public static double getTotalOrganization_BPA_notice(PaymentRegistry paymentRegistry){
        double totalOrganization_BPA_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalOrganization_BPA_notice += payment.getOrganization_BPA_notice();
        }
        return totalOrganization_BPA_notice;
    }

    public static double getTotalOrganization_PNKO_notice(PaymentRegistry paymentRegistry){
        double totalOrganization_PNKO_notice = 0.0;
        ArrayList<Payment> currentPaymentRegistry = paymentRegistry.getPaymentArrayList();

        for (Payment payment : currentPaymentRegistry) {
            totalOrganization_PNKO_notice += payment.getOrganization_PNKO_notice();
        }
        return totalOrganization_PNKO_notice;
    }


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
