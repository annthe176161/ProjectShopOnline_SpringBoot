package org.shoponline.shoponline.service;

import org.shoponline.shoponline.model.Product;
import org.shoponline.shoponline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        return productRepository.findByCategoryID_Id(categoryId);
    }
}