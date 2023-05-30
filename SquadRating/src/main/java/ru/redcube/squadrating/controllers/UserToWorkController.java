package ru.redcube.squadrating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.redcube.squadrating.entity.links.UserToHardWork;
import ru.redcube.squadrating.entity.links.UserToSocialWork;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.entity.work.SocialWork;
import ru.redcube.squadrating.services.links.UserToWorkService;
import ru.redcube.squadrating.services.security.SecurityUserDetailsService;
import ru.redcube.squadrating.services.squadUser.SquadUserService;
import ru.redcube.squadrating.services.work.WorkService;

import java.util.Optional;

@Controller
public class UserToWorkController {

    private final UserToWorkService userToWorkService;
    private final WorkService<HardWork> hardWorkService;
    private final WorkService<SocialWork> socialWorkWorkService;
    private final SquadUserService squadUserService;
    private final SecurityUserDetailsService securityUserDetailsService;


    public UserToWorkController(UserToWorkService userToWorkService,
                                WorkService<HardWork> hardWorkService,
                                WorkService<SocialWork> socialWorkWorkService,
                                SquadUserService squadUserService,
                                SecurityUserDetailsService securityUserDetailsService) {
        this.userToWorkService = userToWorkService;
        this.hardWorkService = hardWorkService;
        this.socialWorkWorkService = socialWorkWorkService;
        this.squadUserService = squadUserService;
        this.securityUserDetailsService = securityUserDetailsService;
    }

    @GetMapping("/userToWorks")
    public String getUserToWorksPage(Model model) {
        model.addAttribute("userToHardWork", userToWorkService.getUserToHardWorks());
        model.addAttribute("userToSocialWork", userToWorkService.getUserToSocialWorks());
        model.addAttribute("securityUserService", securityUserDetailsService);

        return "/user_to_works";
    }

    /**
     * Страница создания посещения производки
     *
     * @param model Модель для посещения производки
     * @return Страница создания посещения производки
     */
    @GetMapping("/userToHardWork/create")
    public String createUserToHardWork(Model model) {
        //TODO добавить пользователя который создает работу
        model.addAttribute("userToHardWork", new UserToHardWork());
        model.addAttribute("works", hardWorkService.getAllWorks());
        model.addAttribute("appUsers", squadUserService.getAllUsers());
        return "/userToHardWork/add";
    }

    /**
     * Создание посещения производки
     *
     * @return Переход на страницу с посещениями
     */
    @PostMapping("/userToHardWork/create")
    public String createUserToHardWork(UserToHardWork userToHardWork) {
        userToWorkService.saveUserToHardWork(userToHardWork);

        return "redirect:/userToWorks";
    }

    /**
     * Страница создания посещения социалки
     *
     * @param model Модель для посещения социалки
     * @return Страница создания посещения социалки
     */
    @GetMapping("/userToSocialWork/create")
    public String createUserToSocialWork(Model model) {
        //TODO добавить пользователя который создает работу
        model.addAttribute("userToSocialWork", new UserToSocialWork());
        model.addAttribute("works", socialWorkWorkService.getAllWorks());
        model.addAttribute("appUsers", squadUserService.getAllUsers());

        return "/userToSocialWork/add";
    }

    /**
     * Создание посещения социалки
     *
     * @return Переход на страницу с посещениями
     */
    @PostMapping("/userToSocialWork/create")
    public String createUserToSocialWork(UserToSocialWork userToSocialWork) {

        userToWorkService.saveUserToSocialWork(userToSocialWork);

        return "redirect:/userToWorks";
    }

    @GetMapping("/userToHardWork/{id}/update")
    public String updateUserToHardWork(@PathVariable("id") Long userToHardWorkId, Model model) {
        Optional<UserToHardWork> userToHardWorkOptional = userToWorkService.getUserToHardWorkById(userToHardWorkId);
        if (userToHardWorkOptional.isPresent()) {
            UserToHardWork userToHardWork = userToHardWorkOptional.get();
            model.addAttribute("userToHardWork", userToHardWork);
            model.addAttribute("works", hardWorkService.getAllWorks());
            model.addAttribute("appUsers", squadUserService.getAllUsers());
        } else {
            return "/error/page";
        }

        return "/userToHardWork/update";
    }

    @PostMapping("/userToHardWork/{id}/update")
    public String updateUserToHardWork(@PathVariable("id") Long userToHardWorkId, UserToHardWork userToHardWork) {
        //TODO добавить обработку ошибок
        userToWorkService.updateUserToHardWork(userToHardWork, userToHardWorkId);
        return "redirect:/userToWorks";
    }

    @RequestMapping(value = "/userToHardWork/{id}/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteUserToHardWork(@PathVariable("id") Long userToHardWorkId) {
        Optional<UserToHardWork> hardWorkOptional = userToWorkService.getUserToHardWorkById(userToHardWorkId);
        if (hardWorkOptional.isPresent()) {
            userToWorkService.deleteUserToHardWork(userToHardWorkId);
        } else {
            return "/error/page";
        }

        return "redirect:/userToWorks";
    }

    @GetMapping("/userToSocialWork/{id}/update")
    public String updateUserToSocialWork(@PathVariable("id") Long userToSocialWorkId, Model model) {
        Optional<UserToSocialWork> userToSocialWorkOptional = userToWorkService.getUserToSocialWorkById(userToSocialWorkId);
        if (userToSocialWorkOptional.isPresent()) {
            UserToSocialWork userToSocialWork = userToSocialWorkOptional.get();
            model.addAttribute("userToSocialWork", userToSocialWork);
            model.addAttribute("works", hardWorkService.getAllWorks());
            model.addAttribute("appUsers", squadUserService.getAllUsers());
        } else {
            return "/error/page";
        }

        return "/userToSocialWork/update";
    }

    @PostMapping("/userToSocialWork/{id}/update")
    public String updateUserToSocialWork(@PathVariable("id") Long userToSocialWorkId, UserToSocialWork userToSocialWork) {
        //TODO добавить обработку ошибок
        userToWorkService.updateUserToSocialWork(userToSocialWork, userToSocialWorkId);
        return "redirect:/userToWorks";
    }

    @RequestMapping(value = "/userToSocialWork/{id}/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteUserToSocialWork(@PathVariable("id") Long userToSocialWorkId) {
        Optional<UserToSocialWork> hardWorkOptional = userToWorkService.getUserToSocialWorkById(userToSocialWorkId);
        if (hardWorkOptional.isPresent()) {
            userToWorkService.deleteUserToSocialWork(userToSocialWorkId);
        } else {
            return "/error/page";
        }

        return "redirect:/userToWorks";
    }

}
