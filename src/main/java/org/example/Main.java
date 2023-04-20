package org.example;

import org.example.models.PaymentRegistry;
import org.example.utils.ParserData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {

//        String newDate = new String("01.12.2022 08:14:19");
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.parse(newDate, formatter);
//
//        System.out.println(dateTime.getDayOfWeek());

        PaymentRegistry paymentRegistry = new PaymentRegistry();
        ParserData parserData = new ParserData();

        paymentRegistry = parserData.ReadRegistry("src/main/resources/ReportFull.csv", paymentRegistry);

        System.out.println("Tut'");


    }
}