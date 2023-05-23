package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewRegistryController {
    @GetMapping("/viewRegistry")
    public String viewRegistry(){
        return "viewRegistry/frame";
    }

    @PostMapping("/registrySearch")
    public String registrySearch(@RequestParam("searchQuery") String searchQuery) {
        // Здесь можно выполнить логику поиска, обработки запроса и т.д.
        // Пример:
        System.out.println("Получен поисковой запрос: " + searchQuery);

        // Возвращаем имя шаблона HTML или перенаправление на другую страницу
        return "viewRegistry/frame";
    }
}
