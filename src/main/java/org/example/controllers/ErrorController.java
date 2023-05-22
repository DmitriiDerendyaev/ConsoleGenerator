package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/")
    public String errorPage(){
        return "/404";
    }

    @GetMapping("/404")
    public String error(){
        return "/404";
    }
}
