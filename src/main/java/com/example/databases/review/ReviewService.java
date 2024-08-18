package com.example.databases.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    List<Review> getAllReviewByCompanyId(Long companyId);
    Review findReviewById(Long id);
    void crateReview(Review review);
    boolean updateReview(Long id, Review review);
    boolean deleteReviewById(Long id);
    boolean deleteReviewByCompanyId(Long id);
}
