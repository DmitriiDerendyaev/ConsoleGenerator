package org.example.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "report")
    private InteractionHistory interactionHistory;

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
    }

    // Добавьте геттеры и сеттеры для всех полей

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InteractionHistory getInteractionHistory() {
        return interactionHistory;
    }

    public void setInteractionHistory(InteractionHistory interactionHistory) {
        this.interactionHistory = interactionHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(LocalDateTime generationTime) {
        this.generationTime = generationTime;
    }

    public Long getGeneratedByPersonId() {
        return generatedByPersonId;
    }

    public void setGeneratedByPersonId(Long generatedByPersonId) {
        this.generatedByPersonId = generatedByPersonId;
    }

    public String getDiagramType() {
        return diagramType;
    }

    public void setDiagramType(String diagramType) {
        this.diagramType = diagramType;
    }

    public double getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(double sumPayment) {
        this.sumPayment = sumPayment;
    }

    public double getSumBPA() {
        return sumBPA;
    }

    public void setSumBPA(double sumBPA) {
        this.sumBPA = sumBPA;
    }

    public double getSumPNKO() {
        return sumPNKO;
    }

    public void setSumPNKO(double sumPNKO) {
        this.sumPNKO = sumPNKO;
    }

    public double getSumCash() {
        return sumCash;
    }

    public void setSumCash(double sumCash) {
        this.sumCash = sumCash;
    }

    public double getSumCard() {
        return sumCard;
    }

    public void setSumCard(double sumCard) {
        this.sumCard = sumCard;
    }

    public double getSumSBP() {
        return sumSBP;
    }

    public void setSumSBP(double sumSBP) {
        this.sumSBP = sumSBP;
    }

    public double getSumOrgBPA() {
        return sumOrgBPA;
    }

    public void setSumOrgBPA(double sumOrgBPA) {
        this.sumOrgBPA = sumOrgBPA;
    }

    public double getSumOrgPNKO() {
        return sumOrgPNKO;
    }

    public void setSumOrgPNKO(double sumOrgPNKO) {
        this.sumOrgPNKO = sumOrgPNKO;
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
