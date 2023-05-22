package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewRegistryController {
    @GetMapping("/viewRegistry")
    public String viewRegistry(){
        return "viewRegistry/frame";
    }
}
