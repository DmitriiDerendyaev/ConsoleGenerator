package org.example.services;

import org.example.models.Report;
import org.example.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report addReport(Report report, Long generatedByPersonId) {
        report.setGeneratedByPersonId(generatedByPersonId);
        return reportRepository.save(report);
    }
}
