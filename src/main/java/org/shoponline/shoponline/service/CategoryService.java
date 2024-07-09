package org.shoponline.shoponline.service;

import org.shoponline.shoponline.model.Category;
import org.shoponline.shoponline.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Service dung de giao tiep voi database
public class CategoryService { // Khai bao CategoryService

    @Autowired // Autowired dung de Spring Boot tu dong tao doi tuong
    private CategoryRepository categoryRepository; // Khai bao CategoryRepository

    public List<Category> getAllCategories() { // Lay tat ca cac danh muc
        return categoryRepository.findAll(); // Tra ve tat ca cac danh muc
    }

    public Category getCategoryById(int id) { // Lay danh muc theo id
        return categoryRepository.findById(id).orElse(null); // Tra ve danh muc theo id
    }
}
