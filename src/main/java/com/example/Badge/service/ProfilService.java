package com.example.Badge.service;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaProfil;
import com.example.Badge.model.Profil;
import com.example.Badge.repository.ProfilRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Profil service.
 */
@Service
public class ProfilService {

    /**
     * The Profil repository.
     */
    @Autowired
    private ProfilRepository profilRepository;

    /**
     * The Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, EventKafkaProfil> kafkaTemplate;

    /**
     * Gets all profils.
     *
     * @return the all profils
     */
    public List<Profil> getAllProfils() {
        return profilRepository.findAll();
    }

    /**
     * Gets profil by id.
     *
     * @param id the id
     * @return the profil by id
     */
    public Optional<Profil> getProfilById(String id) {
        return profilRepository.findById(id);
    }

    /**
     * Gets profil by user id.
     *
     * @param userId the user id
     * @return the profil by user id
     */
    public Profil getProfilByUserId(String userId) {
        return profilRepository.findByUserId(userId);
    }

    /**
     * Create profil profil.
     *
     * @param profil the profil
     * @return the profil
     */
    public Profil createProfil(Profil profil) {
        EventKafkaProfil event = new EventKafkaProfil(Action.CREATE, profil);
        kafkaTemplate.send(Topics.PROFILE, event);
        return profil;
    }

    /**
     * Delete profil.
     *
     * @param id the id
     */
    public void deleteProfil(String id) {
        profilRepository.deleteById(id);
    }
}
