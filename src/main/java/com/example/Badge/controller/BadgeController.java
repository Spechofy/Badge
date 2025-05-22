package com.example.Badge.controller;

import com.example.Badge.model.Badge;
import com.example.Badge.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

//    @Autowired
//    private BadgeService badgeService;
//
//
//    @GetMapping
//    public List<Badge> getAllBadges() {
//        return badgeService.getAllBadges();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Badge> getBadgeById(@PathVariable String id) {
//        return badgeService.getBadgeById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/profil/{profilId}")
//    public List<Badge> getBadgesByProfilId(@PathVariable String profilId) {
//        return badgeService.getBadgesByProfilId(profilId);
//    }
//
//    @PostMapping
//    public Badge createBadge(@RequestBody Badge badge) {
//        return badgeService.createBadge(badge);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Badge> updateBadge(@PathVariable String id, @RequestBody Badge badge) {
//        try {
//            Badge updatedBadge = badgeService.updateBadge(id, badge);
//            return ResponseEntity.ok(updatedBadge);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBadge(@PathVariable String id) {
////        badgeService.deleteBadge(id);
//        return ResponseEntity.noContent().build();
//    }
}

