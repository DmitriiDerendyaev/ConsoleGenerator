package org.example.models;

import java.time.LocalDateTime;

public class Payment {

    private int checkId;
    private int APM;
    private LocalDateTime paymentTime;
    private String operator;
    private String paymentPurpose;
    private String paymentType;
    private double paymentAmount;
    private double BPA_notice;
    private double PNKO_notice;
    private double cashAmount;
    private double cardAmount;
    private double SBP_amount;
    private double organization_BPA_notice;
    private double organization_PNKO_notice;
    private boolean isComplete;

    public Payment(int checkId, int APM, LocalDateTime paymentTime, String operator, String paymentPurpose, String paymentType, double paymentAmount, double BPA_notice, double PNKO_notice, double cashAmount, double cardAmount, double SBP_amount, double organization_BPA_notice, double organization_PNKO_notice, boolean isComplete) {
        this.checkId = checkId;
        this.APM = APM;
        this.paymentTime = paymentTime;
        this.operator = operator;
        this.paymentPurpose = paymentPurpose;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.BPA_notice = BPA_notice;
        this.PNKO_notice = PNKO_notice;
        this.cashAmount = cashAmount;
        this.cardAmount = cardAmount;
        this.SBP_amount = SBP_amount;
        this.organization_BPA_notice = organization_BPA_notice;
        this.organization_PNKO_notice = organization_PNKO_notice;
        this.isComplete = isComplete;
    }

    public int getCheckId() {
        return checkId;
    }

    public int getAPM() {
        return APM;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public String getOperator() {
        return operator;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public double getBPA_notice() {
        return BPA_notice;
    }

    public double getPNKO_notice() {
        return PNKO_notice;
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public double getCardAmount() {
        return cardAmount;
    }

    public double getSBP_amount() {
        return SBP_amount;
    }

    public double getOrganization_BPA_notice() {
        return organization_BPA_notice;
    }

    public double getOrganization_PNKO_notice() {
        return organization_PNKO_notice;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
