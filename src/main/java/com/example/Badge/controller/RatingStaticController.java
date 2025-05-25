package com.example.Badge.controller;

import com.example.Badge.model.RatingStatic;
import com.example.Badge.service.RatingStaticService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

/**
 * The type Rating static controller.
 */
@RestController
@RequestMapping("/ratings")
public class RatingStaticController {

    /**
     * The Rating static service.
     */
    private final RatingStaticService ratingStaticService;

    /**
     * Instantiates a new Rating static controller.
     *
     * @param ratingStaticService the rating static service
     */
    public RatingStaticController(RatingStaticService ratingStaticService) {
        this.ratingStaticService = ratingStaticService;
    }

    /**
     * Gets positive ratings.
     *
     * @param minRate the min rate
     * @return the positive ratings
     */
    @GetMapping("/positive")
    public List<RatingStatic> getPositiveRatings(@RequestParam(defaultValue = "3") int minRate) {
        return ratingStaticService.getPositiveRatings(minRate);
    }

    /**
     * Save rating rating static.
     *
     * @param rating the rating
     * @return the rating static
     */
    @PostMapping
    public RatingStatic saveRating(@RequestBody RatingStatic rating) {
        return ratingStaticService.saveRating(rating);
    }
}
