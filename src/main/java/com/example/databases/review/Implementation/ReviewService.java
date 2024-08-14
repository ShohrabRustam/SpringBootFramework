package com.example.databases.review.Implementation;
import com.example.databases.job.Job;
import com.example.databases.review.Review;
import com.example.databases.review.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements com.example.databases.review.ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public void crateReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public boolean updateReview(Long id, Review updateReview) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()){
            Review review = optionalReview.get();
            review.setTitle(review.getTitle());
            review.setDiscription(review.getDiscription());
            review.setRating(review.getRating());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long id) {
        if(reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
