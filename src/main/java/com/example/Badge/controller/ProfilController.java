package com.example.Badge.controller;

import com.example.Badge.model.Profil;
import com.example.Badge.service.ProfilService;
import org.springframework.http.ResponseEntity;
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
    public Profil createProfil(@RequestBody Profil profil) {
        return profilService.createProfil(profil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profil> updateProfil(@PathVariable String id, @RequestBody Profil profil) {
        try {
            Profil updatedProfil = profilService.updateProfil(id, profil);
            return ResponseEntity.ok(updatedProfil);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfil(@PathVariable String id) {
        profilService.deleteProfil(id);
        return ResponseEntity.noContent().build();
    }
}

