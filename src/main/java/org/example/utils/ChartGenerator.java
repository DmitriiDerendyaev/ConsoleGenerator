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
    public static String chartPieGenerateJSON(HashMap<PaymentType, Double> paymentMap, String paymentParameter){

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
        List<String> columns = new ArrayList<>();
        columns.add("Language");
        columns.add("Percentage");
        dataArray.add(gson.toJsonTree(columns));
        for (int i = 0; i < dataset.getItemCount(); i++) {
            List<Object> data = new ArrayList<>();
            data.add(dataset.getKey(i));
            data.add(dataset.getValue(i));
            dataArray.add(gson.toJsonTree(data));
        }
        jsonObject.add("data", dataArray);
        String jsonString = gson.toJson(jsonObject);

        System.out.println(jsonString);

        return jsonString;
    }

    public static String chartGenerateJSON(HashMap<PaymentType, Double> paymentMap, String paymentParameter) {

        DefaultPieDataset dataset = new DefaultPieDataset();

        for (PaymentType currentType : paymentMap.keySet()) {
            dataset.setValue(currentType.getName(), paymentMap.get(currentType));
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("function drawChart() {\n");
        stringBuilder.append("var data = google.visualization.arrayToDataTable([\n");
        stringBuilder.append("[\"Language\",\"Percentage\"],\n");

        for (int i = 0; i < dataset.getItemCount(); i++) {
            stringBuilder.append("[\"");
            stringBuilder.append(dataset.getKey(i));
            stringBuilder.append("\",");
            stringBuilder.append(dataset.getValue(i));
            stringBuilder.append("],\n");
        }

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]);\n");
        stringBuilder.append("var options = {\n");
        stringBuilder.append("\"title\": \"Первая выгрузка\",\n");
        stringBuilder.append("\"width\": 600,\n");
        stringBuilder.append("\"height\": 300\n");
        stringBuilder.append("};\n");

        return stringBuilder.toString();
    }


    private String prepareFullHTML(JsonObject jsonObject){
        StringBuilder html = new StringBuilder();
        html.append("function drawChart() { var data = google.visualization.arrayToDataTable(");
        html.append(new Gson().toJson(jsonObject));
        html.append("); var options = { 'title': 'Programming Languages', 'width': 400, 'height': 300 };");

        return html.toString();
    }


}
