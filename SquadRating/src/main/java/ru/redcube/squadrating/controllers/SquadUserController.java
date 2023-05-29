package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.services.squadUser.SquadUserService;

@Controller
public class SquadUserController {

    private final SquadUserService squadUserService;

    @Autowired
    public SquadUserController(SquadUserService squadUserService) {
        this.squadUserService = squadUserService;
    }

    @GetMapping("/users")
    public String getMainPage(Model model) {
        model.addAttribute("users", squadUserService.getAllUsers());
        return "/users";
    }
}
