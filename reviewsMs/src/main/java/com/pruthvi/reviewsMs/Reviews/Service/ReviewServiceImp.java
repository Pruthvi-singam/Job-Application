package com.pruthvi.reviewsMs.Reviews.Service;



import com.pruthvi.reviewsMs.Reviews.Entity.Review;
import com.pruthvi.reviewsMs.Reviews.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {
    private  ReviewRepository reviewRepository;
    public ReviewServiceImp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> getAllReviews(Long CompanyId) {
        List<Review> reviews= reviewRepository.findByCompanyId(CompanyId);
        return reviews;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review=reviewRepository.findById(reviewId).orElse(null);
     if(review!=null) {

         reviewRepository.delete(review);
         return true;

     }
        return false;

    }

    @Override
    public boolean createReview(Review review,Long id) {
        if(id!=null&& review!=null) {
            review.setCompanyId(id);
            reviewRepository.save(review);
            return true;
        }
        return false;

    }

    @Override
    public boolean updateReview(Review updateReview,Long reviewId) {
        Review review=reviewRepository.findById(reviewId).orElse(null);
        if(review!=null) {
            review.setTitle(updateReview.getTitle());
            review.setDescription(updateReview.getDescription());
            review.setRating(updateReview.getRating());
            review.setCompanyId(updateReview.getCompanyId());
            reviewRepository.save(review);
            return true;
        }
        return false;

    }

    @Override
    public Review getReview( Long reviewId) {
       return reviewRepository.findById(reviewId).orElse(null);
    }
}
