package org.example.utils;


import org.example.models.Payment;
import org.example.models.PaymentRegistry;
import org.example.models.PaymentType;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ParserData {

    public PaymentRegistry ReadRegistry(String path, PaymentRegistry paymentRegistry) throws IOException {
        PaymentRegistry currentPaymentRegistry = paymentRegistry;
        List<String> readFileContents = getStringFromFile(path);

        paymentRegistry.setContractName(readFileContents.get(1).replaceAll(";", ""));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        paymentRegistry.setStartDate(LocalDate.parse(readFileContents.get(3).split(";")[3], dateFormatter));
        paymentRegistry.setEndDate(LocalDate.parse(readFileContents.get(3).split(";")[4], dateFormatter));


        for(int i = 10; i < readFileContents.size(); i++){
            if(readFileContents.get(i).contains(";;;;")){
                System.out.println("Парсинг файла окончен");
                break;
            }

            String[] elementArray = readFileContents.get(i).split(";");

//            /////////System.out.println(i);
            int checkId = Integer.parseInt(elementArray[2]);
            int APM = Integer.parseInt(elementArray[1]);
            LocalDateTime paymentTime = LocalDateTime.parse(elementArray[0], dateTimeFormatter);
            String operator = elementArray[3];
            String paymentPurpose = elementArray[4];
            PaymentType paymentType;
            if(elementArray[5].matches("\\d{20}")){
                paymentType = PaymentType.FINES;
            } else if (elementArray[6].matches("\\d{10}")) {
                paymentType = PaymentType.STATE_DUTY;
            } else {
                paymentType = PaymentType.SERVICES;
            }
            double paymentAmount = Double.parseDouble(elementArray[8].replaceAll(",", "."));
            double BPA_notice = Double.parseDouble(elementArray[9].replaceAll(",", "."));
            double PNKO_notice = Double.parseDouble(elementArray[10].replaceAll(",", "."));
            double cashAmount = Double.parseDouble(elementArray[11].replaceAll(",", "."));
            double cardAmount = Double.parseDouble(elementArray[12].replaceAll(",", "."));
            double SBP_amount = Double.parseDouble(elementArray[13].replaceAll(",", "."));
            double organization_BPA_notice = Double.parseDouble(elementArray[14].replaceAll(",", "."));
            double organization_PNKO_notice = Double.parseDouble(elementArray[15].replaceAll(",", "."));
            boolean isComplete = Boolean.parseBoolean(elementArray[16].replaceAll(",", "."));

            currentPaymentRegistry.addPayment(new Payment(checkId, APM, paymentTime, operator, paymentPurpose, paymentType,
                    paymentAmount, BPA_notice, PNKO_notice, cashAmount, cardAmount, SBP_amount, organization_BPA_notice,
                    organization_PNKO_notice, isComplete));
        }
        return currentPaymentRegistry;
    }

    static List<String> getStringFromFile(String path){
        try {
            return Files.readAllLines(Path.of(path), Charset.forName("windows-1251"));
        } catch (IOException e) {
            System.err.println("File not found!");
            throw new RuntimeException(e);
        }
    }
}
