package org.shoponline.shoponline.service;

import org.shoponline.shoponline.model.Product;
import org.shoponline.shoponline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<Product> getProductsByCategoryId(int categoryId, Pageable pageable) {
        return productRepository.findByCategoryID_Id(categoryId, pageable);
    }

    public Page<Product> searchProductsByName(String name, Pageable pageable) {
        return productRepository.findByProductNameContainingIgnoreCase(name, pageable);
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
