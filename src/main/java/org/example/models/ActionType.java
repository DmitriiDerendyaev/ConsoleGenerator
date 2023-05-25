package org.example.models;

public enum ActionType {
    CREATE("Создание"),
    READ("Чтение");

    private String description;

    ActionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
