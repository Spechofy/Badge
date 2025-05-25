package com.example.Badge.repository;

import com.example.Badge.model.MusicStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * The interface Music statistic repository.
 */
public interface MusicStatisticRepository extends MongoRepository<MusicStatistic, String> {

}
