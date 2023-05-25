package org.example.models;

import java.time.LocalDateTime;

public class InteractionHistory {
    private Long id;
    private Long reportId;
    private Long personId;
    private LocalDateTime interactionTime;
    private ActionType actionType;

    public InteractionHistory() {
        // Пустой конструктор
    }

    public InteractionHistory(Long reportId, Long personId, LocalDateTime interactionTime, ActionType actionType) {
        this.reportId = reportId;
        this.personId = personId;
        this.interactionTime = interactionTime;
        this.actionType = actionType;
    }

    public Long getId() {
        return id;
    }

    public Long getReportId() {
        return reportId;
    }

    public Long getPersonId() {
        return personId;
    }

    public LocalDateTime getInteractionTime() {
        return interactionTime;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setInteractionTime(LocalDateTime interactionTime) {
        this.interactionTime = interactionTime;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}
