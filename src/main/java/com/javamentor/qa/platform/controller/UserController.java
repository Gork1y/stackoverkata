package com.javamentor.qa.platform.controller;

import com.javamentor.qa.platform.models.entity.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("regpage")
    public String getRegistrationPage(Model model) {
        model.addAttribute("newUser", new User());
        return "regpage";
    }
}
