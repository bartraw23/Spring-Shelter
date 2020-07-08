package com.springshelllter.animaldata.service;

import com.springshelllter.animaldata.models.Animal;
import com.springshelllter.animaldata.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Transactional
    public Animal addAnimal(Animal animal) {
        animal.setDateOfEnrollment(LocalDateTime.now());
        return animalRepository.save(animal);
    }
}
