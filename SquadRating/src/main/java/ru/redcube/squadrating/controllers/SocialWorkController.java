package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.redcube.squadrating.entity.links.UserToSocialWork;
import ru.redcube.squadrating.entity.work.SocialWork;
import ru.redcube.squadrating.services.appuser.AppUserService;
import ru.redcube.squadrating.services.links.UserToWorkService;
import ru.redcube.squadrating.services.work.WorkService;

import java.util.Optional;

@Controller
public class SocialWorkController {


    private final WorkService<SocialWork> socialWorkService;

    @Autowired
    public SocialWorkController(WorkService<SocialWork> socialWorkService) {
        this.socialWorkService = socialWorkService;
    }

    /**
     * Страница со списком всех социальных работ (для админа)
     *
     * @param model Модель для списка социальных работ
     * @return Список всех социальных работ
     */
    @GetMapping("/socialWorks")
    public String getAllWorks(Model model) {
        //TODO добавить сортировку по дате и времени,
        // ролевую модель, админ смотрит все, боец на свой отряд.
        model.addAttribute("socialWorks", socialWorkService.getAllWorks());

        return "/socialWork/list";
    }

    /**
     * Страница создания работы
     *
     * @param model Модель для работы
     * @return Страница создания работы
     */
    @GetMapping("/socialWork/create")
    public String createWork(Model model) {
        //TODO добавить пользователя который создает работу
        model.addAttribute("socialWork", new SocialWork());

        return "/socialWork/add";
    }

    /**
     * Создание работы
     *
     * @return Переход на страницу с работами
     */
    @PostMapping("/socialWork/create")
    public String createWork(SocialWork socialWork) {

        socialWorkService.saveWork(socialWork);

        return "redirect:/socialWorks";
    }

    /**
     * Страница для обновления работы
     *
     * @param model        Модель для работы
     * @param socialWorkId ID работы
     * @return Страница для обновления работы
     */
    @GetMapping("/socialWork/{id}/update")
    public String updateWork(@PathVariable("id") Long socialWorkId, Model model) {
        //TODO добавить ролевую модель
        Optional<SocialWork> socialWorkOptional = socialWorkService.getWorkById(socialWorkId);
        if (socialWorkOptional.isPresent()) {
            SocialWork socialWork = socialWorkOptional.get();
            model.addAttribute("socialWork", socialWork);
        } else {
            return "/error/page";
        }

        return "/socialWork/update";
    }

    /**
     * Обновление работы
     *
     * @param socialWorkId ID работы
     * @param socialWork   работа
     * @return Страница обновленной работы
     */
    @PostMapping("/socialWork/{id}/update")
    public String updateWork(@PathVariable("id") Long socialWorkId, SocialWork socialWork) {
        //TODO добавить обработку ошибок
        socialWorkService.updateWork(socialWork, socialWorkId);
        return "redirect:/socialWorks";
    }

    /**
     * Страница для удаления работы
     *
     * @param model        Модель для работы
     * @param socialWorkId ID работы
     * @return Страница с информацией об удаленной работе
     */
    @RequestMapping(value = "/socialWork/{id}/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteWork(Model model, @PathVariable("id") Long socialWorkId) {
        Optional<SocialWork> socialWorkOptional = socialWorkService.getWorkById(socialWorkId);
        if (socialWorkOptional.isPresent()) {
            SocialWork socialWork = socialWorkOptional.get();
            model.addAttribute("socialWork", socialWork);
            socialWorkService.deleteWork(socialWorkId);
        } else {
            return "/error/page";
        }

        return "/socialWork/delete";
    }

    /**
     * Страница работы
     *
     * @param model        Модель для работы
     * @param socialWorkId Id работы
     * @return Страница работы
     */
    @Transactional
    @GetMapping(value = "/socialWork/{id}")
    public String getWorkById(Model model, @PathVariable("id") Long socialWorkId) {
        Optional<SocialWork> socialWorkOptional = socialWorkService.getWorkById(socialWorkId);
        if (socialWorkOptional.isPresent()) {
            SocialWork socialWork = socialWorkOptional.get();
            model.addAttribute("socialWork", socialWork);
        } else {
            return "/error/page";
        }
        return "/socialWork/detail";
    }
}
