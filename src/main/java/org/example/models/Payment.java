package org.example.models;

import java.time.LocalDateTime;

public class Payment {

    private int checkId;
    private int APM;
    private LocalDateTime paymentTime;
    private String operator;
    private String paymentPurpose;
    private String paymentType;
    private int paymentAmount;
    private int BPA_notice;
    private int PNKO_notice;
    private int cashAmount;
    private int cardAmount;
    private int SBP_amount;
    private int organization_BPA_notice;
    private int organization_PNKO_notice;
    private boolean isComplete;

    public Payment(int checkId, int APM, LocalDateTime paymentTime, String operator, String paymentPurpose, String paymentType, int paymentAmount, int BPA_notice, int PNKO_notice, int cashAmount, int cardAmount, int SBP_amount, int organization_BPA_notice, int organization_PNKO_notice, boolean isComplete) {
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

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public int getBPA_notice() {
        return BPA_notice;
    }

    public int getPNKO_notice() {
        return PNKO_notice;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public int getSBP_amount() {
        return SBP_amount;
    }

    public int getOrganization_BPA_notice() {
        return organization_BPA_notice;
    }

    public int getOrganization_PNKO_notice() {
        return organization_PNKO_notice;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
