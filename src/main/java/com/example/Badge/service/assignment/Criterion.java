package com.example.Badge.service.assignment;

/**
 * The enum Criterion.
 */
public enum Criterion {
  /**
   * Min participation event criterion.
   */
  MIN_PARTICIPATION_EVENT(5),
  /**
   * Min positive ratings criterion.
   */
  MIN_POSITIVE_RATINGS(3),
  /**
   * Min constructive comments criterion.
   */
  MIN_CONSTRUCTIVE_COMMENTS(4),
  /**
   * Min music compatibility criterion.
   */
  MIN_MUSIC_COMPATIBILITY(0.8),
  /**
   * Min rate comments criterion.
   */
  MIN_RATE_COMMENTS(3.5);

  /**
   * The Min.
   */
  private final double min;

  /**
   * Instantiates a new Criterion.
   *
   * @param min the min
   */
  Criterion(double min) {
    this.min = min;
  }

  /**
   * Gets min.
   *
   * @return the min
   */
  public double getMin() {
    return min;
  }
}
