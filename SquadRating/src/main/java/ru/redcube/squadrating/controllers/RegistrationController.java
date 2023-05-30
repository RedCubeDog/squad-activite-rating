package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.redcube.squadrating.entity.dto.RegistrationFormDTO;
import ru.redcube.squadrating.entity.security.SecurityUser;
import ru.redcube.squadrating.entity.squadUser.SquadRole;
import ru.redcube.squadrating.entity.squadUser.SquadUser;
import ru.redcube.squadrating.services.security.SecurityUserDetailsService;
import ru.redcube.squadrating.services.squad.SquadService;

@Controller
public class RegistrationController {

    private final SecurityUserDetailsService securityUserDetailsService;
    private final SquadService squadService;

    @Autowired
    public RegistrationController(SecurityUserDetailsService securityUserDetailsService,
                                  SquadService squadService) {
        this.securityUserDetailsService = securityUserDetailsService;
        this.squadService = squadService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        RegistrationFormDTO registrationForm
                = new RegistrationFormDTO(new SecurityUser(), new SquadUser());
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(RegistrationFormDTO registrationForm,
                          Model model) {
        try {
            SecurityUser securityUser = registrationForm.getSecurityUser();
            SquadUser squadUser = registrationForm.getSquadUser();
            securityUser.setSquadUser(squadUser);
            squadUser.setSecurityUser(securityUser);
            squadUser.setSquadRole(SquadRole.CANDIDATE);
            squadUser.setSquadId(squadService.getSquadById(4L).get());
            securityUserDetailsService.addUser(securityUser);
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("registrationForm", registrationForm);
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
