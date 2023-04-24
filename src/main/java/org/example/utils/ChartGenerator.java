package org.example.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.example.models.PaymentRegistry;
import org.example.models.PaymentType;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChartGenerator {
    public static void chartGenerateJSON(PaymentRegistry paymentRegistry){
        DefaultPieDataset dataset = new DefaultPieDataset();
//        dataset.setValue("Java", 50);
//        dataset.setValue("Python", 20);
//        dataset.setValue("Ruby", 30);

        dataset.setValue(PaymentType.FINES.getName(), PrepareData.getPaymentAmount(paymentRegistry,
                PaymentType.FINES.getName()));
        dataset.setValue(PaymentType.SERVICES.getName(), PrepareData.getPaymentAmount(paymentRegistry,
                PaymentType.SERVICES.getName()));
        dataset.setValue(PaymentType.STATE_DUTY.getName(), PrepareData.getPaymentAmount(paymentRegistry,
                PaymentType.STATE_DUTY.getName()));

        // Создание объекта JFreeChart для диаграммы
        JFreeChart chart = ChartFactory.createPieChart(
                "Programming Languages", dataset, true, true, false);

//        JFreeChart barChart = ChartFactory.createBarChart();


        // Конвертация объекта JFreeChart в JSON для Google Charts
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("chartType", "PieChart");
        JsonArray dataArray = new JsonArray();
        List<String> columns = new ArrayList<String>();
        columns.add("Language");
        columns.add("Percentage");
        dataArray.add(gson.toJsonTree(columns));
        for (int i = 0; i < dataset.getItemCount(); i++) {
            List<Object> data = new ArrayList<Object>();
            data.add(dataset.getKey(i));
            data.add(dataset.getValue(i));
            dataArray.add(gson.toJsonTree(data));
        }
        jsonObject.add("data", dataArray);
        String jsonString = gson.toJson(jsonObject);

        JsonParser parser = new JsonParser();
        JsonObject jsonObject2 = parser.parse(jsonString).getAsJsonObject();
        String chartType = jsonObject2.get("chartType").getAsString();
        JsonArray dataArray2 = jsonObject.get("data").getAsJsonArray();
        List<List<Object>> data = new ArrayList<>();
        for (JsonElement element : dataArray2) {
            List<Object> row = new Gson().fromJson(element, new TypeToken<List<Object>>() {}.getType());
            data.add(row);
        }

        // Создание объекта Google Charts и отображение диаграммы на веб-странице
        StringBuilder html = new StringBuilder();
        html.append("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        html.append("<script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});");
        html.append("google.charts.setOnLoadCallback(drawChart);");
        html.append("function drawChart() { var data = google.visualization.arrayToDataTable(");
        html.append(new Gson().toJson(data));
        html.append("); var options = { 'title': 'Programming Languages', 'width': 400, 'height': 300 };");
        html.append("var chart = new google.visualization." + chartType + "(document.getElementById('chart_div'));");
        html.append("chart.draw(data, options); }</script></head><body><div id=\"chart_div\"></div></body></html>");

        System.out.println(html.toString());

        // Отображение диаграммы Google Charts
        System.out.println(jsonString);
    }

    public static void barChartGenerateJSON(PaymentRegistry paymentRegistry){
//        // Создание набора данных для гистограммы
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(10, "Фрукты", "Яблоки");
//        dataset.addValue(15, "Фрукты", "Апельсины");
//        dataset.addValue(8, "Фрукты", "Бананы");
//        dataset.addValue(5, "Овощи", "Морковь");
//        dataset.addValue(12, "Овощи", "Огурцы");
//        dataset.addValue(3, "Овощи", "Капуста");
//
//// Создание объекта JFreeChart для гистограммы
//        JFreeChart chart = ChartFactory.createBarChart(
//                "Продажи товаров по категориям", // Заголовок диаграммы
//                "Товары",                        // Метка оси X
//                "Количество продаж",             // Метка оси Y
//                dataset,                          // Данные для диаграммы
//                PlotOrientation.VERTICAL,         // Ориентация диаграммы
//                true,                             // Легенда включена
//                true,                             // Включение инструментов визуализации
//                false                             // Включение URL-ссылок
//        );
//
//// Конвертация объекта JFreeChart в JSON для Google Charts
//        Gson gson = new Gson();
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("chartType", "BarChart");
//        JsonArray dataArray = new JsonArray();
//        List<String> columns = new ArrayList<String>();
//        columns.add("Товары");
//        columns.add("Количество продаж");
//        dataArray.add(gson.toJsonTree(columns));
//        for (int i = 0; i < dataset.getRowCount(); i++) {
//            List<Object> data = new ArrayList<Object>();
//            data.add(dataset.getRowKey(i));
//            data.add(dataset.getValue(i, 0));
//            dataArray.add(gson.toJsonTree(data));
//        }
//        jsonObject.add("data", dataArray);
//        String jsonString = gson.toJson(jsonObject);
//
//// Создание объекта Google Charts и отображение диаграммы на веб-странице
//        StringBuilder html = new StringBuilder();
//        html.append("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
//        html.append("<script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});");
//        html.append("google.charts.setOnLoadCallback(drawChart);");
//        html.append("function drawChart() { var data = google.visualization.arrayToDataTable(");
//        html.append(new Gson().toJson(data));
//        html.append("); var options = { 'title': 'Продажи товаров по категориям', 'width': 400, 'height': 300 };");
//        html.append("var chart = new google.visualization." + chartType + "(document.getElementById('chart_div'));");
//        html.append("chart.draw(data, options); }</script></head><body><div id=\"chart_div\"></div></body></html>");
//
//        System.out.println(html.toString());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(PrepareData.getPaymentAmount(paymentRegistry, PaymentType.FINES.getName()), "Payment Amount", PaymentType.FINES.getName());
        dataset.setValue(PrepareData.getPaymentAmount(paymentRegistry, PaymentType.SERVICES.getName()), "Payment Amount", PaymentType.SERVICES.getName());
        dataset.setValue(PrepareData.getPaymentAmount(paymentRegistry, PaymentType.STATE_DUTY.getName()), "Payment Amount", PaymentType.STATE_DUTY.getName());

        JFreeChart chart = ChartFactory.createBarChart(
                "Payment Amount by Type",
                "Payment Type",
                "Payment Amount",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        StringBuilder html = new StringBuilder();
        html.append("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        html.append("<script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});");
        html.append("google.charts.setOnLoadCallback(drawChart);");
        html.append("function drawChart() { var data = google.visualization.arrayToDataTable(");
        html.append(new Gson().toJson(data));
        html.append("); var options = { 'title': 'Payment Amount by Type', 'width': 400, 'height': 300 };");
        html.append("var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
        html.append("chart.draw(data, options); }</script></head><body><div id=\"chart_div\"></div></body></html>");

        System.out.println(html.toString());
    }

}
