package org.shoponline.shoponline.controller;

import org.shoponline.shoponline.model.Category;
import org.shoponline.shoponline.model.Product;
import org.shoponline.shoponline.service.CategoryService;
import org.shoponline.shoponline.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String homepage(Model model,
                           @RequestParam(value = "categoryId", required = false) Integer categoryId,
                           @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "search", required = false) String search,
                           HttpSession session) {
        // Kiểm tra trạng thái đăng nhập
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn == null) {
            isLoggedIn = false;
        }
        model.addAttribute("isLoggedIn", isLoggedIn);

        // Lấy danh sách categories
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        Pageable pageable = PageRequest.of(page, 9);
        Page<Product> productPage;

        if (search != null && !search.isEmpty()) {
            productPage = productService.searchProductsByName(search, pageable);
        } else if (categoryId != null) {
            Category selectedCategory = categoryService.getCategoryById(categoryId);
            model.addAttribute("selectedCategory", selectedCategory);
            productPage = productService.getProductsByCategoryId(categoryId, pageable);
        } else {
            productPage = productService.getAllProducts(pageable);
        }

        model.addAttribute("productPage", productPage);
        model.addAttribute("search", search);
        return "homepage/homepage";
    }

    @GetMapping("/header")
    public String header(Model model) {
        return "fragments/header";
    }

    @GetMapping("/footer")
    public String footer(Model model) {
        return "fragments/footer";
    }

    @GetMapping("/navbar")
    public String navbar(Model model) {
        return "fragments/navbar";
    }
}