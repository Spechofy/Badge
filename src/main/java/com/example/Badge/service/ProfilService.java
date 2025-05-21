package com.example.Badge.service;

import com.example.Badge.model.Profil;
import com.example.Badge.repository.ProfilRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilService {

    private final ProfilRepository profilRepository;

    public ProfilService(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

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
        return profilRepository.save(profil);
    }

    public Profil updateProfil(String id, Profil updatedProfil) {
        return profilRepository.findById(id).map(profil -> {
            profil.setDescription(updatedProfil.getDescription());
            profil.setUserId(updatedProfil.getUserId());
            return profilRepository.save(profil);
        }).orElseThrow(() -> new RuntimeException("Profil not found"));
    }

    public void deleteProfil(String id) {
        profilRepository.deleteById(id);
    }
}
