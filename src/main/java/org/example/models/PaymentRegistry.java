package org.example.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaymentRegistry {
    private ArrayList<Payment> paymentArrayList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String contractName;

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public PaymentRegistry() {
        paymentArrayList = new ArrayList<>();
    }

    public void addPayment(Payment newPayment){
        paymentArrayList.add(newPayment);
    }

    public ArrayList<Payment> getPaymentArrayList() {
        return paymentArrayList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
