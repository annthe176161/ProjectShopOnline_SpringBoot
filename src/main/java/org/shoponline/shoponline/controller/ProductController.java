package org.shoponline.shoponline.controller;

import org.shoponline.shoponline.model.Product;
import org.shoponline.shoponline.model.ProductImage;
import org.shoponline.shoponline.model.Review;
import org.shoponline.shoponline.service.ProductImageService;
import org.shoponline.shoponline.service.ProductService;
import org.shoponline.shoponline.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/product/detail/{productId}")
    public String productDetail(@PathVariable Integer productId, Model model) {
        Product product = productService.getProductById(productId);
        List<ProductImage> images = productImageService.getImagesByProductId(productId);
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        model.addAttribute("product", product);
        model.addAttribute("images", images);
        model.addAttribute("reviews", reviews);
        return "product/detail";
    }
}