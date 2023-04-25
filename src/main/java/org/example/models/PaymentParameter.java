package org.example.models;

public enum PaymentParameter {
    PAYMENT_AMOUNT("Сумма платежа"),
    BPA_NOTICE("Сумма извещения БПА"),
    PNKO_NOTICE("Сумма извещения ПНКО"),
    CASH_AMOUNT("Сумма наличными"),
    CARD_AMOUNT("Сумма картой"),
    SBP_AMOUNT("Сумма СБП"),
    ORGANIZATION_BPA_NOTICE("Сумма Организации(БПА)"),
    ORGANIZATION_PNKO_NOTICE("Сумма Организации(ПНКО)");

    private final String name;

    PaymentParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
