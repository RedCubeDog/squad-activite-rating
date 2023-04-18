package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.redcube.squadrating.configs.User;
import ru.redcube.squadrating.services.config.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        try {
            userService.addUser(user);
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
