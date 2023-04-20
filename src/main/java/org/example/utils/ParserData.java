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
import java.util.List;

public class ParserData {

    public PaymentRegistry ReadRegistry(String path, PaymentRegistry paymentRegistry) throws IOException {
        List<String> readFileContents;

        try {
            readFileContents = Files.readAllLines(Path.of(path), Charset.forName("windows-1251"));
        } catch (IOException e) {
            System.err.println("File not found!");
            throw new RuntimeException(e);
        }

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

//    File xlsxFile = new File("path/to/file.xlsx");
//    File csvFile = new File("path/to/file.csv");
//    XlsxToCsvConverter.convertToCsv(xlsxFile, csvFile);
//
//    public static void convertToCsv(File xlsxFile, File csvFile) throws IOException {
//        try (XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile)) {
//            // Получаем первый лист в книге
//            Row row;
//            Cell cell;
//            try (FileOutputStream csvStream = new FileOutputStream(csvFile)) {
//                // Перебираем все строки и столбцы в листе
//                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//                    for (Row r : workbook.getSheetAt(i)) {
//                        for (int j = 0; j < r.getLastCellNum(); j++) {
//                            cell = r.getCell(j);
//                            if (cell != null) {
//                                // Получаем содержимое ячейки
//                                String value = cell.getStringCellValue();
//                                // Записываем значение ячейки в CSV файл с разделителем ";"
//                                csvStream.write(value.getBytes());
//                                csvStream.write(";".getBytes());
//                            }
//                        }
//                        csvStream.write("\n".getBytes());
//                    }
//                }
//            }
//        }
//    }
}
