package org.example.utils;

import org.example.models.PaymentParameter;
import org.example.models.PaymentRegistry;
import org.example.models.PaymentType;

import java.util.HashMap;

public class PrepareMapToChart {

    public static HashMap<PaymentType, Double> getChartMap(PaymentRegistry paymentRegistry, PaymentParameter paymentParameter){
        HashMap<PaymentType, Double> chartMap = new HashMap<>();

        switch (paymentParameter){
            case PAYMENT_AMOUNT -> {
                chartMap.put(PaymentType.FINES, PrepareData.getPaymentAmount(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getPaymentAmount(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getPaymentAmount(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
            case BPA_NOTICE -> {
                chartMap.put(PaymentType.FINES, PrepareData.getBPA_notice(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getBPA_notice(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getBPA_notice(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
            case PNKO_NOTICE -> {
                chartMap.put(PaymentType.FINES, PrepareData.getPNKO_notice(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getPNKO_notice(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getPNKO_notice(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
            case CASH_AMOUNT -> {
                chartMap.put(PaymentType.FINES, PrepareData.getCashAmount(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getCashAmount(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getCashAmount(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
            case CARD_AMOUNT -> {
                chartMap.put(PaymentType.FINES, PrepareData.getCardAmount(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getCardAmount(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getCardAmount(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
            case SBP_AMOUNT -> {
                chartMap.put(PaymentType.FINES, PrepareData.getSBP_amount(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getSBP_amount(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getSBP_amount(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
            case ORGANIZATION_BPA_NOTICE -> {
                chartMap.put(PaymentType.FINES, PrepareData.getOrganization_BPA_notice(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getOrganization_PNKO_notice(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getOrganization_BPA_notice(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
            case ORGANIZATION_PNKO_NOTICE -> {
                chartMap.put(PaymentType.FINES, PrepareData.getOrganization_PNKO_notice(paymentRegistry, PaymentType.FINES.getName()));
                chartMap.put(PaymentType.SERVICES, PrepareData.getOrganization_PNKO_notice(paymentRegistry, PaymentType.SERVICES.getName()));
                chartMap.put(PaymentType.STATE_DUTY, PrepareData.getOrganization_PNKO_notice(paymentRegistry, PaymentType.STATE_DUTY.getName()));
            }
        }
        return chartMap;

    }
}
