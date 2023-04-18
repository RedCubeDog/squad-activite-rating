package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.services.HardWorkService;
import ru.redcube.squadrating.services.SocialWorkService;
import ru.redcube.squadrating.services.SquadService;
import ru.redcube.squadrating.services.UserService;

@Controller
public class MainPageController {

    private final UserService userService;
    private final SquadService squadService;
    private final SocialWorkService socialWorkService;
    private final HardWorkService hardWorkService;

    @Autowired
    public MainPageController(UserService userService, SquadService squadService,
                              SocialWorkService socialWorkService, HardWorkService hardWorkService) {
        this.userService = userService;
        this.squadService = squadService;
        this.socialWorkService = socialWorkService;
        this.hardWorkService = hardWorkService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("squads", squadService.getSquads());
        return "/index";
    }

    @GetMapping("/works")
    public String getSocialWorkPage(Model model) {
        model.addAttribute("socialWorks", socialWorkService.getSocialWorks());
        model.addAttribute("hardWorks", hardWorkService.getHardWorks());

        return "/works";
    }
}
