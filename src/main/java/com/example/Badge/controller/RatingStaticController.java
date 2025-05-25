package com.example.Badge.controller;

import com.example.Badge.model.RatingStatic;
import com.example.Badge.service.RatingStaticService;

import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * The type Rating static controller.
 */
@RestController
@RequestMapping("/ratings")
@AllArgsConstructor
public class RatingStaticController {

    /**
     * The Rating static service.
     */
    private final RatingStaticService ratingStaticService;



    /**
     * Gets positive ratings.
     *
     * @param minRate the min rate
     * @return the positive ratings
     */
    @GetMapping("/positive")
    public List<RatingStatic>
    getPositiveRatings(@RequestParam final int minRate) {
        return ratingStaticService.getPositiveRatings(minRate);
    }

    /**
     * Save rating static.
     *
     * @param rating the rating
     * @return the rating static
     */
    @PostMapping
    public RatingStatic saveRating(@RequestBody final RatingStatic rating) {
        return ratingStaticService.saveRating(rating);
    }
}
