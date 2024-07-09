package org.shoponline.shoponline.service;

import org.shoponline.shoponline.model.ProductImage;
import org.shoponline.shoponline.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    public List<ProductImage> getImagesByProductId(int productId) {
        return productImageRepository.findByProductID_Id(productId);
    }
}
