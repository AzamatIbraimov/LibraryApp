package com.library.controller;

import com.library.entity.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@CrossOrigin
@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "views/registerForm";
    }




    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if (user.getName().equals("ADMIN")) {
            userService.createAdmin(user);
            return "views/main";
        }
        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist", true);
            return "views/registerForm";
        }
        userService.createUser(user);

        return "views/main";

    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }
        return "mainController";
    }


    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/main")
    public String showMain() {
        return "views/main";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "views/loginForm";
    }

    @PostMapping("/admin")
    public String registerAdmin(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist", true);
            return "views/registerForm";
        }
        userService.createAdmin(user);
        return "views/main";

    }

}