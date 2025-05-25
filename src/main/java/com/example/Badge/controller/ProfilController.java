package com.example.Badge.controller;

import com.example.Badge.model.Profil;
import com.example.Badge.service.ProfilService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Profil controller.
 */
@RestController
@RequestMapping("/api/profils")
public class ProfilController {

  /**
   * The Profil service.
   */
  private final ProfilService profilService;

  /**
   * Instantiates a new Profil controller.
   *
   * @param profilService the profil service
   */
  public ProfilController(ProfilService profilService) {
    this.profilService = profilService;
  }

  /**
   * Gets all profils.
   *
   * @return the all profils
   */
  @GetMapping
  public List<Profil> getAllProfils() {
    return profilService.getAllProfils();
  }

  /**
   * Gets profil by id.
   *
   * @param id the id
   * @return the profil by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<Profil> getProfilById(@PathVariable String id) {
    return profilService
        .getProfilById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * Gets profil by user id.
   *
   * @param userId the user id
   * @return the profil by user id
   */
  @GetMapping("/user/{userId}")
  public ResponseEntity<Profil> getProfilByUserId(@PathVariable String userId) {
    Profil profil = profilService.getProfilByUserId(userId);
    if (profil != null) {
      return ResponseEntity.ok(profil);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Create profil response entity.
   *
   * @param profil the profil
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<String> createProfil(@RequestBody Profil profil) {
    profilService.createProfil(profil);
    return ResponseEntity.ok("Profil envoyé via Kafka avec succès !");
  }

  /**
   * Delete profil response entity.
   *
   * @param id the id
   * @return the response entity
   */
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
