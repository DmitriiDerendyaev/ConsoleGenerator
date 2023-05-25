package org.example.controllers;

import org.example.models.PaymentParameter;
import org.example.models.PaymentRegistry;
import org.example.models.PaymentType;
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
import java.util.HashMap;


@Controller
public class GenerateController {

    @GetMapping("/generate")
    public String generate(){
        return "generationSettings/frame";
    }
    @PostMapping("/handleButtonClick")
    public String handleButtonClick(@RequestParam("chartType") String chartType,
                                    @RequestParam("radio") String radio,
                                    @RequestParam("file") MultipartFile file, Model model) throws IOException {

        PaymentRegistry paymentRegistry = new PaymentRegistry();
        ParserData parserData = new ParserData();

        paymentRegistry = parserData.ReadRegistry(file, paymentRegistry);


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

        return "generationSettings/frame";
    }


}