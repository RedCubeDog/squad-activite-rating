package ru.redcube.squadrating.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.services.links.UserToWorkService;

@Controller
public class UserToWorkController {

    private final UserToWorkService userToWorkService;


    public UserToWorkController(UserToWorkService userToWorkService) {
        this.userToWorkService = userToWorkService;
    }

    @GetMapping("/userToWorks")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATION_STATE')")
    public String getUserToWorksPage(Model model) {
        model.addAttribute("userToHardWork",userToWorkService.getUserToHardWorks());
        model.addAttribute("userToSocialWork",userToWorkService.getUserToSocialWorks());

        return "/user_to_works";
    }
}
