package org.example.services;

import org.example.models.InteractionHistory;
import org.example.models.Person;
import org.example.models.Report;
import org.example.repository.InteractionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionHistoryService {

    private final InteractionHistoryRepository interactionHistoryRepository;

    @Autowired
    public InteractionHistoryService(InteractionHistoryRepository interactionHistoryRepository) {
        this.interactionHistoryRepository = interactionHistoryRepository;
    }

    public InteractionHistory addInteractionHistory(InteractionHistory interactionHistory, Long reportId, Long personId) {
        Report report = interactionHistory.getReport();
        report.setId(reportId);
        interactionHistory.setReport(report);

        Person person = interactionHistory.getPerson();
        person.setId(personId);
        interactionHistory.setPerson(person);

        return interactionHistoryRepository.save(interactionHistory);
    }
}
