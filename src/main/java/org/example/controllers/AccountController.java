package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/account2")
    public String account(){
        return "personalAccount/frame";
    }

    @GetMapping("/account")
    public String example(Model model) {
        // Заполняем переменные модели значениями
        model.addAttribute("variableName", "Вася");
        model.addAttribute("variableSurname", "Иванов");
        model.addAttribute("variableRole", "Младший сотрудник");
        model.addAttribute("variablePatronymic", "Александрович");
        model.addAttribute("variableEmail", "dds_stalker@mail.ru");
        model.addAttribute("variablePhoneNumber", "+798888888888");

        // Возвращаем имя шаблона Thymeleaf
        return "personalAccount/frame";
    }
}
