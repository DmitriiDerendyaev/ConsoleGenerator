package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.models.*;
import org.example.services.InteractionHistoryService;
import org.example.services.PaymentService;
import org.example.services.PersonService;
import org.example.services.ReportService;
import org.example.utils.ChartGenerator;
import org.example.utils.ParserData;
import org.example.utils.PrepareData;
import org.example.utils.PrepareMapToChart;
import org.jfree.chart.title.Title;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;


@Controller
public class GenerateController {
    private final PaymentService paymentService;
    private final ReportService reportService;
    private final InteractionHistoryService interactionHistoryService;
    private final PersonService personService;

    public GenerateController(PaymentService paymentService,
                              ReportService reportService,
                              InteractionHistoryService interactionHistoryService,
                              PersonService personService) {
        this.paymentService = paymentService;
        this.reportService = reportService;
        this.interactionHistoryService = interactionHistoryService;
        this.personService = personService;
    }

    @GetMapping("/generate")
    public String generate(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));
        return "generationSettings/frame";
    }
    @PostMapping("/generateReport")
    public String handleButtonClick(@RequestParam("chartType") String chartType,
                                    @RequestParam("radio") String radio,
                                    @RequestParam("file") MultipartFile file,
                                    Model model,
                                    HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));

        PaymentRegistry paymentRegistry = new PaymentRegistry();
        ParserData parserData = new ParserData();

        paymentRegistry = parserData.ReadRegistry(file, paymentRegistry);

//        for (Payment payment : paymentRegistry.getPaymentArrayList()) {
//            System.out.println("checkID: " + payment.getCheckId());
//            paymentService.addPayment(payment);
//        }

        switch (radio){
            case "Сумма платежа":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.PAYMENT_AMOUNT);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;
            }
            case "Сумма извещения БПА":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.BPA_NOTICE);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;

            }
            case "Сумма извещения ПНКО":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.PNKO_NOTICE);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;
            }
            case "Сумма наличными":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.CASH_AMOUNT);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;
            }
            case "Сумма картой":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.CARD_AMOUNT);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;
            }
            case "Сумма СБП":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.SBP_AMOUNT);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;
            }
            case "Сумма Организации (БПА)":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.ORGANIZATION_BPA_NOTICE);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;
            }
            case "Сумма Организации (ПНКО)":
            {
                HashMap<PaymentType, Double> chartMap = PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.ORGANIZATION_PNKO_NOTICE);
                model.addAttribute("fines", chartMap.get(PaymentType.FINES));
                model.addAttribute("services", chartMap.get(PaymentType.SERVICES));
                model.addAttribute("state", chartMap.get(PaymentType.STATE_DUTY));
                break;
            }
            default:
                System.out.println("Неверный тип данных для диаграммы");
        }

        model.addAttribute("typeGeneration", radio);
        model.addAttribute("typeDiagram", chartType);

        model.addAttribute("sumPayment", PrepareData.getTotalPaymentAmount(paymentRegistry));
        model.addAttribute("sumBPA", PrepareData.getTotalBPA_notice(paymentRegistry));
        model.addAttribute("sumPNKO", PrepareData.getTotalPNKO_notice(paymentRegistry));
        model.addAttribute("sumCash", PrepareData.getTotalCashAmount(paymentRegistry));
        model.addAttribute("sumCard", PrepareData.getTotalCardAmount(paymentRegistry));
        model.addAttribute("sumSBP", PrepareData.getTotalSBP_amount(paymentRegistry));
        model.addAttribute("sumOrgBPA", PrepareData.getTotalOrganization_BPA_notice(paymentRegistry));
        model.addAttribute("sumOrgPNKO", PrepareData.getTotalOrganization_PNKO_notice(paymentRegistry));

        System.out.println("Chart Type: " + chartType);
        System.out.println("Selected Radio: " + radio);

        Report report = new Report();
        report.setName(chartType);
        report.setGenerationTime(LocalDateTime.now());
        report.setGeneratedByPersonId((Long) session.getAttribute("userId"));
        report.setDiagramType(radio);
        report.setSumPayment(PrepareData.getTotalPaymentAmount(paymentRegistry));
        report.setSumBPA(PrepareData.getTotalBPA_notice(paymentRegistry));
        report.setSumPNKO(PrepareData.getTotalPNKO_notice(paymentRegistry));
        report.setSumCash(PrepareData.getTotalCashAmount(paymentRegistry));
        report.setSumCard(PrepareData.getTotalCardAmount(paymentRegistry));
        report.setSumSBP(PrepareData.getTotalSBP_amount(paymentRegistry));
        report.setSumOrgBPA(PrepareData.getTotalOrganization_BPA_notice(paymentRegistry));
        report.setSumOrgPNKO(PrepareData.getTotalOrganization_PNKO_notice(paymentRegistry));
        report.setTimeRangeStart(paymentRegistry.getStartDate().atStartOfDay());
        report.setTimeRangeEnd(paymentRegistry.getEndDate().atStartOfDay());

        Report savedReport = reportService.addReport(report, report.getGeneratedByPersonId());

        // Создание и сохранение истории работы с отчетом
        InteractionHistory interactionHistory = new InteractionHistory();
        interactionHistory.setReport(savedReport);
        interactionHistory.setPerson(personService.findByLogin((String) session.getAttribute("login")));
        interactionHistory.setInteractionTime(LocalDateTime.now());
        interactionHistory.setActionType(ActionType.CREATE);

        interactionHistoryService.addInteractionHistory(interactionHistory, report.getId(), (Long) session.getAttribute("userId"));

        return "generationSettings/frame";
    }


}