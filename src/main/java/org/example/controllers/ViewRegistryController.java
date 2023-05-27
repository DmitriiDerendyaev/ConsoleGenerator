package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.models.Payment;
import org.example.models.PaymentType;
import org.example.repository.PaymentRepository;
import org.example.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewRegistryController {
    private PaymentService paymentService;
    public ViewRegistryController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping("/viewRegistry")
    public String viewRegistry(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));

//        List<Payment> payments = paymentRepository.findAll(); // Получение всех платежей из репозитория
        List<Payment> randomPayments = paymentService.getRandomPayments(100);
        model.addAttribute("payments", randomPayments); // Передача списка платежей в модель

        return "viewRegistry/frame";
    }

    @PostMapping("/registrySearch")
    public String registrySearch(@RequestParam("searchQuery") String searchQuery,
                                 Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));
        // Здесь можно выполнить логику поиска, обработки запроса и т.д.
        // Пример:
        System.out.println("Получен поисковой запрос: " + searchQuery);

        List<Payment> parameterPayments = paymentService.getPaymentsByType(PaymentType.valueOf(searchQuery));
        model.addAttribute("payments", parameterPayments); // Передача списка платежей в модель

        // Возвращаем имя шаблона HTML или перенаправление на другую страницу
        return "viewRegistry/frame";
    }
}
