package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.services.SquadService;
import ru.redcube.squadrating.services.UserService;

@Controller
public class MainPageController {

    private final UserService userService;
    private final SquadService squadService;

    @Autowired
    public MainPageController(UserService userService, SquadService squadService) {
        this.userService = userService;
        this.squadService = squadService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("squads", squadService.getSquads());
        return "/index";
    }
}
