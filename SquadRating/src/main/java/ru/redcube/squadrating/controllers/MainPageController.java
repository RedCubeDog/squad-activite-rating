package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.services.work.HardWorkService;
import ru.redcube.squadrating.services.work.SocialWorkService;
import ru.redcube.squadrating.services.squad.SquadService;
import ru.redcube.squadrating.services.appuser.AppUserService;

@Controller
public class MainPageController {

    private final AppUserService appUserService;
    private final SquadService squadService;
    private final SocialWorkService socialWorkService;
    private final HardWorkService hardWorkService;

    @Autowired
    public MainPageController(AppUserService appUserService, SquadService squadService,
                              SocialWorkService socialWorkService, HardWorkService hardWorkService) {
        this.appUserService = appUserService;
        this.squadService = squadService;
        this.socialWorkService = socialWorkService;
        this.hardWorkService = hardWorkService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("users", appUserService.getUsers());
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
