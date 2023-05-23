package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String registration(){
        return "registration/frame";
    }

    @GetMapping("/fillRegistration")
    public String fillRegistration(){
        return "fillRegistration/frame";
    }

    @PostMapping("/your-server-endpoint")
    public String processForm(Model model, @RequestParam String login, @RequestParam String password) {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);

        // Добавьте здесь логику для обработки данных, если необходимо

        return "fillRegistration/frame"; // Замените "success" на имя представления, которое вы хотите отобразить после обработки формы
    }

    @PostMapping("/fillRegistration-endpoint")
    public String processRegistrationForm(
            @RequestParam("name") String name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("surname") String surname
    ) {
        System.out.println("Name: " + name);
        System.out.println("Patronymic: " + patronymic);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Surname: " + surname);

        return "mainPage/frame";
    }
}
