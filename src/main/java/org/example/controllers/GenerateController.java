package org.example.controllers;

import org.example.models.PaymentParameter;
import org.example.models.PaymentRegistry;
import org.example.models.PaymentType;
import org.example.utils.ChartGenerator;
import org.example.utils.ParserData;
import org.example.utils.PrepareData;
import org.example.utils.PrepareMapToChart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class GenerateController {

    @GetMapping("/generate")
    public String generate(){
        return "generationSettings/frame";
    }
    @PostMapping("/handleButtonClick")
    public String handleButtonClick(@RequestParam("file") MultipartFile file) throws IOException {
        // Получение пути к файлу
        String filePath = file.getOriginalFilename();
        System.out.println("Путь к файлу: " + filePath);

        PaymentRegistry paymentRegistry = new PaymentRegistry();
        ParserData parserData = new ParserData();
        PrepareData prepareData = new PrepareData();

        paymentRegistry = parserData.ReadRegistry(filePath, paymentRegistry);

        ChartGenerator.chartGenerateJSON(PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.BPA_NOTICE));

        System.out.println(prepareData.getPaymentAmount(paymentRegistry, PaymentType.FINES.getName()));

        return "generationSettings/frame";
    }
}