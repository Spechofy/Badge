package com.example.Badge.kafka.event;

import com.example.Badge.model.MusicStatistic;
import lombok.*;

/**
 * The type Event kafka music statistic.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaMusicStatistic {
  /**
   * The Action.
   */
  private Action action;
  /**
   * The Data.
   */
  private MusicStatistic data;
}
