package org.example;

import org.example.models.PaymentRegistry;
import org.example.utils.ParserData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {

        PaymentRegistry paymentRegistry = new PaymentRegistry();
        ParserData parserData = new ParserData();

        paymentRegistry = parserData.ReadRegistry("src/main/resources/ReportFull.csv", paymentRegistry);

        System.out.println("Tut'");


    }
}