package com.example.Badge.controller;

import com.example.Badge.model.Profil;
import com.example.Badge.service.ProfilService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfilControllerTest {

    @Mock
    private ProfilService profilService;

    @InjectMocks
    private ProfilController profilController;

    private Profil profil;

    @BeforeEach
    void setUp() {
        profil = new Profil();
        // configure ici profil si nécessaire (ex: profil.setId("123"))
    }

    @Test
    void testGetAllProfils() {
        List<Profil> profils = List.of(profil, new Profil());
        when(profilService.getAllProfils()).thenReturn(profils);

        List<Profil> result = profilController.getAllProfils();

        assertEquals(2, result.size());
        verify(profilService, times(1)).getAllProfils();
    }

    @Test
    void testGetProfilById_found() {
        when(profilService.getProfilById("123")).thenReturn(Optional.of(profil));

        ResponseEntity<Profil> response = profilController.getProfilById("123");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(profil, response.getBody());
        verify(profilService).getProfilById("123");
    }

    @Test
    void testGetProfilById_notFound() {
        when(profilService.getProfilById("123")).thenReturn(Optional.empty());

        ResponseEntity<Profil> response = profilController.getProfilById("123");

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void testGetProfilByUserId_found() {
        when(profilService.getProfilByUserId("user123")).thenReturn(profil);

        ResponseEntity<Profil> response = profilController.getProfilByUserId("user123");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(profil, response.getBody());
    }

    @Test
    void testGetProfilByUserId_notFound() {
        when(profilService.getProfilByUserId("user123")).thenReturn(null);

        ResponseEntity<Profil> response = profilController.getProfilByUserId("user123");

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

//    @Test
//    void testCreateProfil() {
//        doNothing().when(profilService).createProfil(profil);
//
//        ResponseEntity<String> response = profilController.createProfil(profil);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals("Profil envoyé via Kafka avec succès !", response.getBody());
//        verify(profilService, times(1)).createProfil(profil);
//    }

    @Test
    void testDeleteProfil_found() {
        when(profilService.getProfilByUserId("123")).thenReturn(profil);
        doNothing().when(profilService).deleteProfil("123");

        ResponseEntity<String> response = profilController.deleteProfil("123");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("demande suppression envoyé via Kafka avec succès !", response.getBody());
        verify(profilService).deleteProfil("123");
    }

    @Test
    void testDeleteProfil_notFound() {
        when(profilService.getProfilByUserId("123")).thenReturn(null);

        ResponseEntity<String> response = profilController.deleteProfil("123");

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
