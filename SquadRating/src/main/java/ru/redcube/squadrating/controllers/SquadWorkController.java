package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.redcube.squadrating.entity.dto.SquadAndHoursDTO;
import ru.redcube.squadrating.services.links.UserToWorkService;

import java.util.List;

@Controller
public class SquadWorkController {

    private final UserToWorkService userToWorkService;

    @Autowired
    public SquadWorkController(UserToWorkService userToWorkService) {
        this.userToWorkService = userToWorkService;
    }

    @GetMapping("/squadWorks")
    public String getSquadWorks(Model model) {
        List<SquadAndHoursDTO> squadsAndHours =
                SquadAndHoursDTO.squadsAndHours(userToWorkService.getUserToHardWorks(),
                        userToWorkService.getUserToSocialWorks());
        model.addAttribute("squadsAndHours", squadsAndHours);
        return "/squad_works";
    }
}
