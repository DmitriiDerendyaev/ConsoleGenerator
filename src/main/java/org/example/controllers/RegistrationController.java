package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
