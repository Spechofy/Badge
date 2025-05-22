package com.example.Badge.kafka.consumer;

import com.example.Badge.model.Profil;
import com.example.Badge.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProfilKafkaConsumer {

    @Autowired
    private  ProfilRepository profilRepository;

    @KafkaListener(topics = "profils-topic", groupId = "spechofy-group")
    public void listenProfil(Profil profil) {
        profilRepository.save(profil);
        System.out.println(profil);
    }
}

