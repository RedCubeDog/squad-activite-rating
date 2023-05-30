package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.entity.dto.SquadAndHoursDTO;
import ru.redcube.squadrating.repositories.squad.SquadRepository;
import ru.redcube.squadrating.services.links.UserToWorkService;
import ru.redcube.squadrating.services.security.SecurityUserDetailsService;

import java.util.List;

@Controller
public class SquadWorkController {

    private final UserToWorkService userToWorkService;
    private final SecurityUserDetailsService securityUserDetailsService;
    private final SquadRepository squadRepository;

    @Autowired
    public SquadWorkController(UserToWorkService userToWorkService,
                               SecurityUserDetailsService securityUserDetailsService,
                               SquadRepository squadRepository) {
        this.userToWorkService = userToWorkService;
        this.securityUserDetailsService = securityUserDetailsService;
        this.squadRepository = squadRepository;
    }

    @GetMapping("/squadWorks")
    public String getSquadWorks(Model model) {
        List<SquadAndHoursDTO> squadsAndHours =
                SquadAndHoursDTO.squadsAndHours(userToWorkService.getUserToHardWorks(),
                        userToWorkService.getUserToSocialWorks());
        model.addAttribute("squadsAndHours", squadsAndHours);
        model.addAttribute("securityUserService", securityUserDetailsService);
        model.addAttribute("squadRepository", squadRepository);
        return "/squad_works";
    }
}
