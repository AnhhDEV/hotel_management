package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping
    public String loginUI() {
        return "demo/login";
    }

    @PostMapping
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        boolean isValidUser = loginRepository.existsByUsernameAndPassword(username, password);

        if (isValidUser) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu.");
            return "demo/login";
        }
    }

}
