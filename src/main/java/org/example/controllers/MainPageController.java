package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.models.Report;
import org.example.services.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainPageController {
    private final ReportService reportService;

    public MainPageController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/mainPage")
    public String mainPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));

        List<Report> reports = reportService.getAllReports();
        model.addAttribute("reports", reports);
        return "mainPage/frame";
    }

    @PostMapping("/mainSearch")
    public String mainSearch(@RequestParam("searchQuery") String searchQuery,
                             Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));
        // Здесь можно выполнить логику поиска, обработки запроса и т.д.
        // Пример:
        System.out.println("Получен поисковой запрос: " + searchQuery);

        // Возвращаем имя шаблона HTML или перенаправление на другую страницу
        return "mainPage/frame";
    }
}
