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

@Controller
public class RegistrationController {

    private final SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    public RegistrationController(SecurityUserDetailsService securityUserDetailsService) {
        this.securityUserDetailsService = securityUserDetailsService;
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
            securityUserDetailsService.addUser(securityUser);
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("registrationForm", registrationForm);
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
