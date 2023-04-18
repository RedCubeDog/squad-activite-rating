package ru.redcube.squadrating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String getLoginOrRegistration() {
        return "/loginOrRegistration";
    }

    @GetMapping("/mainPage")
    public String getMainPage() {
        return "/index";
    }
}
