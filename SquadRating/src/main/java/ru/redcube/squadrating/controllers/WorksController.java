package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.services.work.SocialWorkService;
import ru.redcube.squadrating.services.work.WorkService;

@Controller
public class WorksController {

    private final SocialWorkService socialWorkService;
    private final WorkService<HardWork> hardWorkService;

    @Autowired
    public WorksController(SocialWorkService socialWorkService, WorkService<HardWork> hardWorkService) {
        this.socialWorkService = socialWorkService;
        this.hardWorkService = hardWorkService;
    }

    @GetMapping("/works")
    public String getWorksPage(Model model) {
        model.addAttribute("socialWorks", socialWorkService.getSocialWorks());
        model.addAttribute("hardWorks", hardWorkService.getAllWorks());

        return "/works";
    }

    @PostMapping("/addNewWork")
    public String addNewWork(HardWork hardWork, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-work";
        }

        hardWorkService.saveWork(hardWork);

        return "redirect:/works";
    }

    @PostMapping("/works/deleteWork")
    public String deleteWork(@RequestParam("workId") long id) {
        hardWorkService.deleteWork(id);
        return "redirect:/works";
    }

    @PostMapping("/works/saveWork")
    public String updateWork(@ModelAttribute("hardWork") HardWork hardWork) {

        hardWorkService.saveWork(hardWork);

        return "redirect:/works";
    }

    @PostMapping("/works/edit")
    public String showUpdateForm(@RequestParam("workId") long id, Model model) {
        HardWork hardWork = hardWorkService.getWork(id);
        model.addAttribute("hardWork", hardWork);

        return "update-work";
    }

}
