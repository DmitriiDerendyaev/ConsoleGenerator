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

        if(chartType.equals("relative")){
            switch (radio){
                case "Сумма платежа":
                {
                    model.addAttribute("diagram",
                            ChartGenerator.chartGenerateJSON(PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.PAYMENT_AMOUNT), PaymentParameter.PAYMENT_AMOUNT.getName()));
                    System.out.println("Так выглядит вывод: " + ChartGenerator.chartGenerateJSON(PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.PAYMENT_AMOUNT), PaymentParameter.PAYMENT_AMOUNT.getName()));
                }
                default:
                    System.out.println("Неверный тип данных для диаграммы");
            }
        }


        model.addAttribute("sumPayment", PrepareData.getTotalPaymentAmount(paymentRegistry));
        System.out.println(PrepareData.getTotalPaymentAmount(paymentRegistry));
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


    @PostMapping("/submitDiagram")
    public String submitForm(@RequestParam("chartType") String chartType,
                             @RequestParam("radio") String radio) {
        System.out.println("Chart Type: " + chartType);
        System.out.println("Selected Radio: " + radio);

        // Дополнительная логика обработки данных формы может быть добавлена здесь

        return "generationSettings/frame"; // Перенаправление на страницу успешного завершения
    }

}