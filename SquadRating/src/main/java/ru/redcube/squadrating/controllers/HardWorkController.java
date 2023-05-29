package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.services.work.WorkService;

import java.util.Optional;

@Controller
public class HardWorkController {


    private final WorkService<HardWork> hardWorkService;

    @Autowired
    public HardWorkController(WorkService<HardWork> hardWorkService) {
        this.hardWorkService = hardWorkService;
    }

    /**
     * Страница со списком всех производственных работ (для админа)
     *
     * @param model Модель для списка производственной работы
     * @return Список всех производственных работ
     */
    @GetMapping("/hardWorks")
    public String getAllHardWorks(Model model) {
        //TODO добавить сортировку по дате и времени,
        // ролевую модель, админ смотрит все, боец на свой отряд.
        model.addAttribute("hardWorks", hardWorkService.getAllWorks());

        return "/hardWork/list";
    }

    /**
     * Страница создания работы
     *
     * @param model Модель для работы
     * @return Страница создания работы
     */
    @GetMapping("/hardWork/create")
    public String createHardWork(Model model) {
        //TODO добавить пользователя который создает работу
        model.addAttribute("hardWork", new HardWork());

        return "/hardWork/add";
    }

    /**
     * Создание работы
     *
     * @return Переход на страницу с работами
     */
    @PostMapping("/hardWork/create")
    public String createHardWork(HardWork hardWork) {

        hardWorkService.saveWork(hardWork);

        return "redirect:/hardWorks";
    }

    /**
     * Страница для обновления работы
     *
     * @param model      Модель для работы
     * @param hardWorkId ID работы
     * @return Страница для обновления работы
     */
    @GetMapping("/hardWork/{id}/update")
    public String updateHardWork(@PathVariable("id") Long hardWorkId, Model model) {
        //TODO добавить ролевую модель
        Optional<HardWork> hardWorkOptional = hardWorkService.getWorkById(hardWorkId);
        if (hardWorkOptional.isPresent()) {
            HardWork hardWork = hardWorkOptional.get();
            model.addAttribute("hardWork", hardWork);
        } else {
            return "/error/page";
        }

        return "/hardWork/update";
    }

    /**
     * Обновление работы
     *
     * @param hardWorkId ID работы
     * @param hardWork   работы
     * @return Переход на страницу с работами
     */
    @PostMapping("/hardWork/{id}/update")
    public String updateHardWork(@PathVariable("id") Long hardWorkId, HardWork hardWork) {
        //TODO добавить обработку ошибок
        hardWorkService.updateWork(hardWork, hardWorkId);
        return "redirect:/hardWorks";
    }

    /**
     * Страница для удаления работы
     *
     * @param model      Модель для работы
     * @param hardWorkId ID работы
     * @return Страница с информацией об удаленной работе
     */
    @RequestMapping(value = "/hardWork/{id}/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteHardWork(Model model, @PathVariable("id") Long hardWorkId) {
        Optional<HardWork> hardWorkOptional = hardWorkService.getWorkById(hardWorkId);
        if (hardWorkOptional.isPresent()) {
            HardWork hardWork = hardWorkOptional.get();
            model.addAttribute("hardWork", hardWork);
            hardWorkService.deleteWork(hardWorkId);
        } else {
            return "/error/page";
        }

        return "/hardWork/delete";
    }

    /**
     * Страница работы
     *
     * @param model      Модель для работы
     * @param hardWorkId Id работы
     * @return Страница работы
     */
    @Transactional
    @GetMapping(value = "/hardWork/{id}")
    public String getWorkById(Model model, @PathVariable("id") Long hardWorkId) {
        Optional<HardWork> hardWorkOptional = hardWorkService.getWorkById(hardWorkId);
        if (hardWorkOptional.isPresent()) {
            HardWork hardWork = hardWorkOptional.get();
            model.addAttribute("hardWork", hardWork);
        } else {
            return "/error/page";
        }
        return "/hardWork/detail";
    }

}
