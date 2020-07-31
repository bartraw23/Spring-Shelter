package com.springshelter.viewmicroservice.controller;

import com.springshelter.viewmicroservice.service.AnimalService;
import com.springshelter.viewmicroservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class ViewController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    WebClient.Builder webClientBuilder;

    @GetMapping
    public String viewIndex(Model model) {
        String greeting = authService.getGreeting();

        model.addAttribute("greeting", greeting);

        return "index";
    }

    @GetMapping("/form")
    public String addAnimalForm() {
        return "form";
    }

    @GetMapping("/animals")
    public String viewAnimals(Model model) {
        String greeting = authService.getGreeting();

        model.addAttribute("greeting", greeting);

        return "animalList";
    }

}
