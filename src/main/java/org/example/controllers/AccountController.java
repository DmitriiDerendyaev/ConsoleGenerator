package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/account")
    public String account(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("variableName", session.getAttribute("variableName"));
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));
        model.addAttribute("variableRole", session.getAttribute("variableRole"));
        model.addAttribute("variablePatronymic", session.getAttribute("variablePatronymic"));
        model.addAttribute("variableEmail", session.getAttribute("variableEmail"));
        model.addAttribute("variablePhoneNumber", session.getAttribute("variablePhoneNumber"));
        return "personalAccount/frame";
    }

    @GetMapping("/accountFilled")
    public String example(Model model, HttpServletRequest request) {
        // Заполняем переменные модели значениями
        HttpSession session = request.getSession();
        model.addAttribute("variableName", session.getAttribute("variableName"));
        model.addAttribute("variableSurname", session.getAttribute("variableSurname"));
        model.addAttribute("variableRole", session.getAttribute("variableRole"));
        model.addAttribute("variablePatronymic", session.getAttribute("variablePatronymic"));
        model.addAttribute("variableEmail", session.getAttribute("variableEmail"));
        model.addAttribute("variablePhoneNumber", session.getAttribute("variablePhoneNumber"));

        // Возвращаем имя шаблона Thymeleaf
        return "personalAccount/frame";
    }
}
