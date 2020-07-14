package com.springshelter.viewmicroservice.controller;

import com.springshelter.viewmicroservice.models.Animal;
import com.springshelter.viewmicroservice.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shelter")
public class ViewController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String viewIndex() {
        return "index";
    }

    @GetMapping("form")
    public String addAnimalForm() {
        return "form";
    }

    @GetMapping("/animals")
    public String viewAnimals(Model model) {
        List<Animal> animals = animalService.getAnimalsList().getAnimals();
        model.addAttribute("animals", animals);
        return "animalList";
    }

}
