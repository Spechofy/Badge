package com.example.Badge.controller;

import com.example.Badge.model.RatingStatic;
import com.example.Badge.service.RatingStaticService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingStaticController {

    private final RatingStaticService ratingStaticService;

    public RatingStaticController(RatingStaticService ratingStaticService) {
        this.ratingStaticService = ratingStaticService;
    }

    @GetMapping("/positive")
    public List<RatingStatic> getPositiveRatings(@RequestParam(defaultValue = "3") int minRate) {
        return ratingStaticService.getPositiveRatings(minRate);
    }

    @PostMapping
    public RatingStatic saveRating(@RequestBody RatingStatic rating) {
        return ratingStaticService.saveRating(rating);
    }
}
