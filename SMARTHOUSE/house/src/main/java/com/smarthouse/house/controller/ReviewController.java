package com.smarthouse.house.controller;

import com.smarthouse.house.entity.Review;
import com.smarthouse.house.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // CREATE
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    // READ - All reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // READ - Review by ID
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id,
                               @RequestBody Review review) {

        Review existingReview =
                reviewRepository.findById(id).orElse(null);

        if (existingReview != null) {
            existingReview.setRating(review.getRating());
            existingReview.setComment(review.getComment());
            existingReview.setCreatedAt(review.getCreatedAt());
            existingReview.setStudent(review.getStudent());
            existingReview.setProperty(review.getProperty());

            return reviewRepository.save(existingReview);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {

        reviewRepository.deleteById(id);

        return "Review deleted successfully";
    }
}