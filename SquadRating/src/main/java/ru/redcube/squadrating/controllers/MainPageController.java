package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.services.work.HardWorkService;
import ru.redcube.squadrating.services.work.SocialWorkService;
import ru.redcube.squadrating.services.squad.SquadService;
import ru.redcube.squadrating.services.squadUser.SquadUserService;

@Controller
public class MainPageController {

    private final SquadUserService squadUserService;
    private final SquadService squadService;
    private final SocialWorkService socialWorkService;
    private final HardWorkService hardWorkService;

    @Autowired
    public MainPageController(SquadUserService squadUserService, SquadService squadService,
                              SocialWorkService socialWorkService, HardWorkService hardWorkService) {
        this.squadUserService = squadUserService;
        this.squadService = squadService;
        this.socialWorkService = socialWorkService;
        this.hardWorkService = hardWorkService;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "/index";
    }

    @GetMapping("/users")
    public String getAllUsersPage(Model model) {
        model.addAttribute("users", squadUserService.getUsers());
        model.addAttribute("squads", squadService.getSquads());

        return "/allUsers";
    }

    @GetMapping("/works")
    @PreAuthorize("hasAnyAuthority('ROLE_BASIC_STATE')")
    public String getSocialWorkPage(Model model) {
        model.addAttribute("socialWorks", socialWorkService.getSocialWorks());
        model.addAttribute("hardWorks", hardWorkService.getHardWorks());

        return "/works";
    }
}
