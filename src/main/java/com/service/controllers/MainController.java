package com.service.controllers;

import com.service.domain.Abit;
import com.service.repos.AbitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    AbitRepo abitRepo;

    @GetMapping
    public String greeting(@RequestParam(name="name", required=false, defaultValue="User") String name, Model model) {
        model.addAttribute("name", name);
        return "emptyMapping";
    }

    @GetMapping("/abit-service")
    public String testDb(Model model) {
        model.addAttribute("abits", abitRepo.findAll());
        return "main";
    }

    @PostMapping("/abit-service")
    public String addAbit(@RequestParam String name, @RequestParam String subjects, Model model) {
        Abit abit = new Abit(name, subjects);
        abitRepo.save(abit);
        model.addAttribute("abits", abitRepo.findAll());
        return "main";
    }


}
