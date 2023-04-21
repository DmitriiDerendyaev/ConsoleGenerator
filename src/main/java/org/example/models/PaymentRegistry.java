package org.example.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaymentRegistry {
    private ArrayList<Payment> paymentArrayList;
    private LocalDate startDate;
    private LocalDate endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
