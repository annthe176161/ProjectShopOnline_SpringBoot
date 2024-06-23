package org.shoponline.shoponline.controller;

import org.shoponline.shoponline.model.Product;
import org.shoponline.shoponline.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String homepage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "homepage";
    }
}