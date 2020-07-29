package com.springshelter.animaldata.service;

import com.springshelter.animaldata.models.Animal;
import com.springshelter.animaldata.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

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
    public List<Animal> findByName(String name) {
        return animalRepository.findByName(name);
    }

    @Transactional
    public List<Animal> findAll() {
        return animalRepository.findAll();
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
