package org.shoponline.shoponline.controller;

import jakarta.servlet.http.HttpSession;
import org.shoponline.shoponline.model.User;
import org.shoponline.shoponline.model.UserRoleMap;
import org.shoponline.shoponline.model.UserRoleMapId;
import org.shoponline.shoponline.service.UserService;
import org.shoponline.shoponline.service.UserRoleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleMapService userRoleMapService;

    @GetMapping("/login")
    public String login(Model model) {
        return "register/login"; // Trỏ đến đường dẫn đúng của template
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session,
                            Model model) {
        User user = userService.findByUserName(username);
        if (user != null && user.getPasswordHash().equals(password)) { // Cần mã hóa mật khẩu và kiểm tra mã băm mật khẩu
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("username", user.getUserName());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "register/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register/register";
    }

    @PostMapping("/register")
    public String registerPost(@RequestParam("username") String username,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        if (userService.findByUserName(username) != null) {
            model.addAttribute("error", "Username already exists");
            return "register/register";
        }
        User newUser = new User();
        newUser.setUserName(username);
        newUser.setEmail(email);
        newUser.setPasswordHash(password); // Cần mã hóa mật khẩu
        userService.save(newUser);

        // Gán role "User" cho user mới đăng ký
        UserRoleMapId userRoleMapId = new UserRoleMapId();
        userRoleMapId.setUserID(newUser.getId());
        userRoleMapId.setRoleID(2); // RoleID cho "User" là 2

        UserRoleMap userRoleMap = new UserRoleMap();
        userRoleMap.setId(userRoleMapId);
        userRoleMap.setUserID(newUser);
        userRoleMap.setAssignedAt(Instant.now());
        userRoleMapService.saveUserRoleMap(userRoleMap);

        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        return "register/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String forgotPasswordPost(@RequestParam("email") String email,
                                     Model model) {
        // Xử lý logic quên mật khẩu tại đây, ví dụ: gửi email với liên kết để đặt lại mật khẩu
        model.addAttribute("message", "If an account with that email exists, a password reset link has been sent.");
        return "register/forgot-password";
    }
}