package ru.redcube.squadrating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String getLoginOrRegistration() {
        return "index";
    }

    @GetMapping("/mainPage")
    public String getMainPage() {
        return "main-page";
    }
}
