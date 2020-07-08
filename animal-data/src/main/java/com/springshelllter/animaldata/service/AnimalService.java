package com.springshelllter.animaldata.service;

import com.springshelllter.animaldata.models.Animal;
import com.springshelllter.animaldata.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Transactional
    public Animal addAnimal(Animal animal) {
        animal.setDateOfEnrollment(LocalDateTime.now());
        return animalRepository.save(animal);
    }

    @Transactional
    public Optional<Animal> findById(UUID id) {
        return animalRepository.findById(id);
    }

    @Transactional
    public boolean delete(UUID id) {
        if (findById(id).isPresent()) {
            animalRepository.delete(findById(id).get());
            return true;
        }
        return false;
    }
}
