package com.pruthvi.reviewsMs.Reviews.Controller;

import com.pruthvi.reviewsMs.Reviews.Entity.Review;
import com.pruthvi.reviewsMs.Reviews.Service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId)
    {

        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam Long companyId ,@RequestBody Review review)
    {
        boolean temp=reviewService.createReview(review,companyId);
        if(temp)
              return new ResponseEntity<>("Review add successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review add to failed check the id once",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@RequestBody Review review)
    {
        boolean temp=reviewService.updateReview(review,reviewId);
        if(temp)
            return new ResponseEntity<>("Review update successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review update failed check the id once",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId)
    {
        Review review=reviewService.getReview(reviewId);
        if(review!=null)
            return new ResponseEntity<>(review,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId)
    {
        boolean temp=reviewService.deleteReview(reviewId);
        if(temp)
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review deleted failed check the id once",HttpStatus.NOT_FOUND);
    }

}
