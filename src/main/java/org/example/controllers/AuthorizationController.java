package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.models.Person;
import org.example.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {
    private final PersonService personService;

    public AuthorizationController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/authorization")
    public String authorization(){
        return "authorization/frame";
    }

    @PostMapping("/tryAuthorization")
    public String tryAuthorization(@RequestParam("login") String login, @RequestParam("password") String password,
                                   HttpServletRequest request) {
        // Проверка логина и пароля
        if (personService.existsByLogin(login)/* && personService.checkPassword(login, password)*/) {
            Person person = personService.findByLogin(login);
            HttpSession session = request.getSession();
            session.setAttribute("variableName", person.getName());
            session.setAttribute("variableSurname", person.getSurname());
            session.setAttribute("variableRole", "Сотрудник");
            session.setAttribute("variablePatronymic", person.getPatronymic());
            session.setAttribute("variableEmail", person.getEmail());
            session.setAttribute("variablePhoneNumber", person.getPhone());
            return "redirect:/mainPage";
        } else {
            // Неправильные учетные данные, перенаправление на страницу ошибки
            return "authorization/frame";
        }
    }


}
