package com.springshelllter.animaldata.controller;

import com.springshelllter.animaldata.models.Animal;
import com.springshelllter.animaldata.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public Animal addHero(@RequestBody @Valid Animal animal) {
        return animalService.addAnimal(animal);
    }
}
