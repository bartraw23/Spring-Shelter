package com.springshelter.animaldata.controller;

import com.springshelter.animaldata.dto.AnimalDto;
import com.springshelter.animaldata.models.Animal;
import com.springshelter.animaldata.models.MailAndDate;
import com.springshelter.animaldata.service.AnimalService;
import com.springshelter.animaldata.service.VisitationService;
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
    private VisitationService visitationService;

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

    @GetMapping
    public List<AnimalDto> getAllAnimals() {
        return animalService.findAll();
    }

    @PostMapping("/{id}/visit")
    public boolean requestVisit(@PathVariable("id") UUID id, @RequestBody MailAndDate mailAndDate) {
        return visitationService.makeVisitation(id, mailAndDate);
    }
}
