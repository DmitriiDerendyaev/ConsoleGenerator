package org.example.models;

public enum PaymentType {
    FINES("Штрафы и налоги"),
    STATE_DUTY("Государственная пошлина"),
    SERVICES("Государственные услуги");//услуги коммерция организации/  услуги контрагентов

    private final String name;

    PaymentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
