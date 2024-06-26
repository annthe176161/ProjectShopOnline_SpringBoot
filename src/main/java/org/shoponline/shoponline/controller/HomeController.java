package org.shoponline.shoponline.controller;

import org.shoponline.shoponline.model.Category;
import org.shoponline.shoponline.model.Product;
import org.shoponline.shoponline.service.CategoryService;
import org.shoponline.shoponline.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String homepage(Model model, @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        List<Product> products;
        if (categoryId != null) {
            Category selectedCategory = categoryService.getCategoryById(categoryId);
            model.addAttribute("selectedCategory", selectedCategory);
            products = productService.getProductsByCategoryId(categoryId);
        } else {
            products = productService.getAllProducts();
        }
        model.addAttribute("products", products);

        return "homepage/homepage";
    }

    @GetMapping("/header")
    public String headerTest(Model model) {
        return "fragments/header";
    }

    @GetMapping("/footer")
    public String footerTest(Model model) {
        return "fragments/footer";
    }

    @GetMapping("/navbar")
    public String navbarTest(Model model) {
        return "fragments/navbar";
    }
}