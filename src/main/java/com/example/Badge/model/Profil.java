package com.example.Badge.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profils")

public class Profil {

    @Id
    private String profilId;
    private String description;
    private String userId;

    public String getProfilId() {
        return profilId;
    }

    public void setProfilId(String profilId) {
        this.profilId = profilId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

