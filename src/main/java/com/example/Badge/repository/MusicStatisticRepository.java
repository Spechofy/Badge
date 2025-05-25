package com.example.Badge.repository;

import com.example.Badge.model.MusicStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The interface Music statistic repository.
 */
public interface MusicStatisticRepository extends MongoRepository<MusicStatistic, String> {}
