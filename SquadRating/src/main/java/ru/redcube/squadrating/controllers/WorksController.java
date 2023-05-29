package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.services.work.HardWorkService;
import ru.redcube.squadrating.services.work.SocialWorkService;

@Controller
public class WorksController {

    private final SocialWorkService socialWorkService;
    private final HardWorkService hardWorkService;

    @Autowired
    public WorksController(SocialWorkService socialWorkService, HardWorkService hardWorkService) {
        this.socialWorkService = socialWorkService;
        this.hardWorkService = hardWorkService;
    }

    @GetMapping("/works")
    public String getSocialWorkPage(Model model) {
        model.addAttribute("socialWorks", socialWorkService.getSocialWorks());
        model.addAttribute("hardWorks", hardWorkService.getHardWorks());

        return "/works";
    }
}
