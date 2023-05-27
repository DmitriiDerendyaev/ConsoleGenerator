package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.models.Person;
import org.example.services.PaymentService;
import org.example.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    private final PersonService personService;

    public RegistrationController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration/frame";
    }


    @GetMapping("/fillRegistration")
    public String fillRegistration(){
        return "fillRegistration/frame";
    }

    @PostMapping("/primaryRegistration")
    public String processForm(Model model, @RequestParam String login, @RequestParam String password,
                              HttpServletRequest request) {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);

        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        session.setAttribute("password", password);

        // Добавьте здесь логику для обработки данных, если необходимо
        return "fillRegistration/frame"; // Замените "success" на имя представления, которое вы хотите отобразить после обработки формы
    }

        @PostMapping("/fillRegistration-endpoint")
    public String processRegistrationForm(
            @RequestParam("name") String name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("surname") String surname,
            HttpServletRequest request
    ) {
        System.out.println("Name: " + name);
        System.out.println("Patronymic: " + patronymic);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Surname: " + surname);

        HttpSession session = request.getSession();
        System.out.println("Login: " + session.getAttribute("login"));
        System.out.println("Password: " + session.getAttribute("password"));

        personService.savePerson(new Person(name, patronymic, phone,email,surname,
                (String) session.getAttribute("login"), (String) session.getAttribute("password")));

        return "redirect:/authorization";
    }
}
