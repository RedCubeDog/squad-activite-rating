package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.redcube.squadrating.configs.entities.User;
import ru.redcube.squadrating.entity.dto.RegistrationFormDTO;
import ru.redcube.squadrating.entity.user.SquadUser;
import ru.redcube.squadrating.services.appuser.AppUserService;
import ru.redcube.squadrating.services.config.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService,
                                  AppUserService appUserService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        RegistrationFormDTO registrationForm
                = new RegistrationFormDTO(new User(), new SquadUser());
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(RegistrationFormDTO registrationForm,
                          Model model) {
        try {
            User securityUser = registrationForm.getSecurityUser();
            SquadUser squadUser = registrationForm.getSquadUser();
            securityUser.setSquadUser(squadUser);
            squadUser.setSecurityUser(securityUser);
            userService.addUser(securityUser);
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("registrationForm", registrationForm);
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
