package com.springshellter.animaldata.controller;

import com.springshellter.animaldata.models.Animal;
import com.springshellter.animaldata.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public Animal addAnimal(@RequestBody @Valid Animal animal) {
        return animalService.addAnimal(animal);
    }


    @DeleteMapping("/{id}")
    public boolean deleteAnimal(@PathVariable("id") UUID id) {
        return animalService.delete(id);
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable("id") UUID id) {
        return animalService.findById(id).get();
    }

    @GetMapping("/name/{name}")
    public List<Animal> getAnimalsByName(@PathVariable("name") String name) {
        return animalService.findByName(name);
    }

}
