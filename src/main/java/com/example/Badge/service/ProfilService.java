package com.example.Badge.service;

import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaProfil;
import com.example.Badge.kafka.Topics;
import com.example.Badge.model.Profil;
import com.example.Badge.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilService {

    @Autowired
    private  ProfilRepository profilRepository;

    @Autowired
    private KafkaTemplate<String, EventKafkaProfil> kafkaTemplate;


    public List<Profil> getAllProfils() {
        return profilRepository.findAll();
    }

    public Optional<Profil> getProfilById(String id) {
        return profilRepository.findById(id);
    }

    public Profil getProfilByUserId(String userId) {
        return profilRepository.findByUserId(userId);
    }

    public Profil createProfil(Profil profil) {
        EventKafkaProfil event = new EventKafkaProfil(Action.CREATE, profil);
        kafkaTemplate.send(Topics.PROFILE, event);
        return profil;
    }


    public void deleteProfil(String id) {
        profilRepository.deleteById(id);
    }
}
