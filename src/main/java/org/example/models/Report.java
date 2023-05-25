package org.example.models;

import java.time.LocalDateTime;

public class Report {
    private Long id;
    private String name;
    private LocalDateTime generationTime;
    private Long generatedByPersonId;
    private String diagramType;
    private double sumPayment;
    private double sumBPA;
    private double sumPNKO;
    private double sumCash;
    private double sumCard;
    private double sumSBP;
    private double sumOrgBPA;
    private double sumOrgPNKO;
    private LocalDateTime timeRangeStart;
    private LocalDateTime timeRangeEnd;

    public Report() {
        // Пустой конструктор
    }

    // Другие конструкторы, геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGeneratedByPersonId() {
        return generatedByPersonId;
    }

    public void setGeneratedByPersonId(Long generatedByPersonId) {
        this.generatedByPersonId = generatedByPersonId;
    }

    public LocalDateTime getTimeRangeStart() {
        return timeRangeStart;
    }

    public void setTimeRangeStart(LocalDateTime timeRangeStart) {
        this.timeRangeStart = timeRangeStart;
    }

    public LocalDateTime getTimeRangeEnd() {
        return timeRangeEnd;
    }

    public void setTimeRangeEnd(LocalDateTime timeRangeEnd) {
        this.timeRangeEnd = timeRangeEnd;
    }
}
