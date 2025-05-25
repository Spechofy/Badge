package com.example.Badge.kafka.consumer;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.EventKafkaProfil;
import com.example.Badge.model.Profil;
import com.example.Badge.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/** The type Profil kafka consumer. */
@Service
public class ProfilKafkaConsumer {

  @Autowired private ProfilRepository profilRepository;

  /**
   * Listen profil.
   *
   * @param eventKafka the event kafka
   */
  @KafkaListener(topics = Topics.PROFILE, groupId = "spechofy-group")
  public void listenProfil(EventKafkaProfil eventKafka) {
    Profil profil = (Profil) eventKafka.getData();
    switch (eventKafka.getAction()) {
      case CREATE:
        profilRepository.save(profil);
        break;
      case DELETE:
        profilRepository.delete(profil);
        break;
    }
  }
}
