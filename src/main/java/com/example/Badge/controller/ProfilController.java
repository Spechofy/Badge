package com.example.Badge.controller;

import com.example.Badge.kafka.Topics;
import com.example.Badge.model.Profil;
import com.example.Badge.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profils")
public class ProfilController {

    private final ProfilService profilService;

    public ProfilController(ProfilService profilService) {
        this.profilService = profilService;
    }

    @GetMapping
    public List<Profil> getAllProfils() {
        return profilService.getAllProfils();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profil> getProfilById(@PathVariable String id) {
        return profilService.getProfilById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Profil> getProfilByUserId(@PathVariable String userId) {
        Profil profil = profilService.getProfilByUserId(userId);
        if (profil != null) {
            return ResponseEntity.ok(profil);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createProfil(@RequestBody Profil profil) {
        profilService.createProfil(profil);
        return ResponseEntity.ok("Profil envoyé via Kafka avec succès !");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfil(@PathVariable String id) {
        Profil profil = profilService.getProfilByUserId(id);
        if (profil != null) {
            profilService.deleteProfil(id);
            return ResponseEntity.ok("demande suppression envoyé via Kafka avec succès !");
        }

        return ResponseEntity.noContent().build();
    }
}

