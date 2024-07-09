package org.shoponline.shoponline.service;

import org.shoponline.shoponline.model.Review;
import org.shoponline.shoponline.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByProductId(int productId) {
        return reviewRepository.findByProductID_Id(productId);
    }
}
