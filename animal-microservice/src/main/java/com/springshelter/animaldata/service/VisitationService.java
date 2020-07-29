package com.springshelter.animaldata.service;

import com.springshelter.animaldata.models.Animal;
import com.springshelter.animaldata.models.MailAndDate;
import com.springshelter.animaldata.models.Visitation;
import com.springshelter.animaldata.repository.VisitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class VisitationService {

    @Autowired
    private VisitationRepository visitationRepository;

    @Autowired
    private AnimalService animalService;


    public Boolean makeVisitation(UUID uuid, MailAndDate mailAndDate) {
        Optional<Animal> optionalAnimal = animalService.findById(uuid);

        if (optionalAnimal.isEmpty() && !optionalAnimal.isPresent()) {
            return false;
        }

        Animal animal = optionalAnimal.get();

        Visitation visitation = new Visitation(mailAndDate.getMail(), animal, mailAndDate.getDate());

        visitationRepository.save(visitation);

        return true;
    }
}
