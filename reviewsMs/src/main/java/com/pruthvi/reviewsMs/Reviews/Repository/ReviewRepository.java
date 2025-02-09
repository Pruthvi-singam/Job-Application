package com.pruthvi.reviewsMs.Reviews.Repository;

import com.pruthvi.reviewsMs.Reviews.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(Long companyId);
}
