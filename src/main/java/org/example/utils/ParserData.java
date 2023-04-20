package org.example.utils;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.example.models.PaymentRegistry;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ParserData {

    public PaymentRegistry ReadRegistry(String path, PaymentRegistry paymentRegistry) throws IOException {
        List<String> readFileContents = getStringFromFile(path);

        paymentRegistry.setContractName(readFileContents.get(1).replaceAll(";", ""));

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String start = readFileContents.get(3).split(";")[3];
        String end = readFileContents.get(3).split(";")[4];
        paymentRegistry.setStartDate(LocalDateTime.parse(readFileContents.get(3).split(";")[3]));
        paymentRegistry.setEndDate(LocalDateTime.parse(readFileContents.get(3).split(";")[4]));


        for(int i = 1; i < readFileContents.size(); i++){
            String[] elementArray = readFileContents.get(i).split(";");

            int checkId = Integer.parseInt(elementArray[0]);
            int APM;
            LocalDateTime paymentTime;
            String operator;
            String paymentPurpose;
            String paymentType;
            int paymentAmount;
            int BPA_notice;
            int PNKO_notice;
            int cashAmount;
            int cardAmount;
            int SBP_amount;
            int organization_BPA_notice;
            int organization_PNKO_notice;
            boolean isComplete;
        }

        return paymentRegistry;
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
