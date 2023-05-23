package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.redcube.squadrating.entity.security.SecurityUser;
import ru.redcube.squadrating.services.security.SecurityUserDetailsService;

@Controller
public class RegistrationController {

    private final SecurityUserDetailsService userService;

    @Autowired
    public RegistrationController(SecurityUserDetailsService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(SecurityUser user, Model model) {
        try {
            userService.addUser(user);
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}

