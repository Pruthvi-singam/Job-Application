package com.pruthvi.reviewsMs.Reviews.Service;


import com.pruthvi.reviewsMs.Reviews.Entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long CompanyId);
    boolean deleteReview(Long ReviewId);
    boolean createReview(Review review,Long id);
    boolean updateReview(Review review,Long reviewId);
    Review getReview(Long reviewId);
}
