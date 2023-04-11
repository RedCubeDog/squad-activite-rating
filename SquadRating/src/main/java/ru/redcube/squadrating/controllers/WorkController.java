package ru.redcube.squadrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.redcube.squadrating.entity.work.Work;
import ru.redcube.squadrating.services.WorkService;

import java.util.List;


@Controller
public class WorkController {

    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping(value = "/works")
    @ResponseBody
    public List<Work> getWorks() {
        return workService.getWorks();
    }
}
