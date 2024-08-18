package com.example.databases.review;

import com.example.databases.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("companies/")
public class ReviewController {
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("review")
    public ResponseEntity<String> createReviews(@RequestBody Review review){
        reviewService.crateReview(review);
        return new ResponseEntity<>("Review Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("reviews")
    public ResponseEntity<List<Review>>getAllReview(){
        return new ResponseEntity<>(reviewService.getAllReviews(),HttpStatus.ACCEPTED);
    }

    @GetMapping("reviews/{id}")
    public ResponseEntity<Review> getReviewByid(@PathVariable Long id){
        Review review = reviewService.findReviewById(id);
        if(review!=null)
            return new ResponseEntity<>(review, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{companyId}/reviews")
    public ResponseEntity<Review> getByCompanyId(@PathVariable Long companyId){
        return new ResponseEntity<Review>((Review) reviewService.getAllReviewByCompanyId(companyId),
                HttpStatus.FOUND);
    }
}
