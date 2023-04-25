package org.example.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.models.PaymentRegistry;
import org.example.models.PaymentType;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChartGenerator {
    public static void chartGenerateJSON(HashMap<PaymentType, Double> paymentMap){
        DefaultPieDataset dataset = new DefaultPieDataset();

        for(PaymentType currentType: paymentMap.keySet()){
            dataset.setValue(currentType.getName(), paymentMap.get(currentType));
        }

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
        System.out.println(dataArray);
    }

    public static void chartGenerateJSON_version_2(HashMap<PaymentType, Double> paymentMap){
        DefaultPieDataset dataset = new DefaultPieDataset();

        for(PaymentType currentType: paymentMap.keySet()){
            dataset.setValue(currentType.getName(), paymentMap.get(currentType));
        }

        // Создание объекта JFreeChart для диаграммы
        JFreeChart chart = ChartFactory.createPieChart(
                "Programming Languages", dataset, true, true, false);

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

        // Создание объекта Google Charts и отображение диаграммы на веб-странице
        StringBuilder html = new StringBuilder();
        html.append("<html><head><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        html.append("<script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});");
        html.append("google.charts.setOnLoadCallback(drawChart);");
        html.append("function drawChart() { var data = google.visualization.arrayToDataTable(");
        html.append(new Gson().toJson(jsonObject));
        html.append("); var options = { 'title': 'Programming Languages', 'width': 400, 'height': 300 };");
        html.append("var chart = new google.visualization." + jsonObject.get("chartType").getAsString() + "(document.getElementById('chart_div'));");
        html.append("chart.draw(data, options); }</script></head><body><div id=\"chart_div\"></div></body></html>");

        System.out.println(html.toString());

        // Отображение диаграммы Google Charts
        System.out.println(jsonString);
        System.out.println(dataArray);
    }

}
