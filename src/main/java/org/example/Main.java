package org.example;

import org.example.models.PaymentParameter;
import org.example.models.PaymentRegistry;
import org.example.models.PaymentType;
import org.example.utils.ChartGenerator;
import org.example.utils.ParserData;
import org.example.utils.PrepareData;
import org.example.utils.PrepareMapToChart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {

//        ChartGenerator.chartGenerate();

        PaymentRegistry paymentRegistry = new PaymentRegistry();
        ParserData parserData = new ParserData();
        PrepareData prepareData = new PrepareData();

        paymentRegistry = parserData.ReadRegistry("src/main/resources/fodsFormat.csv", paymentRegistry);

        ChartGenerator.chartGenerateJSON(PrepareMapToChart.getChartMap(paymentRegistry, PaymentParameter.BPA_NOTICE));

        System.out.println(prepareData.getPaymentAmount(paymentRegistry, PaymentType.FINES.getName()));
        System.out.println("Tut'");
    }
}