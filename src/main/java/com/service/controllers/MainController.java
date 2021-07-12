package com.service.controllers;

import com.service.domain.Abit;
import com.service.domain.MathRes;
import com.service.domain.PhysRes;
import com.service.domain.RusRes;
import com.service.repos.AbitRepo;
import com.service.repos.MathResRepo;
import com.service.repos.PhysResRepo;
import com.service.repos.RusResRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private AbitRepo abitRepo;

    @Autowired
    private RusResRepo rusResRepo;

    @Autowired
    private MathResRepo mathResRepo;

    @Autowired
    private PhysResRepo physResRepo;

    @GetMapping
    public String greeting(@RequestParam(name="name", required=false, defaultValue="User") String name, Model model) {
        model.addAttribute("name", name);
        return "emptyMapping";
    }

    @GetMapping("/abits")
    public String testDb(Model model) {
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }

    @PostMapping("/add-abit")
    public String addAbit(@RequestParam String name, @RequestParam(value = "select") String subjects, Model model) {
        Abit abit = new Abit(name, subjects);
        abitRepo.save(abit);
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }

    @PostMapping("/add-results")
    public String addResults(@RequestParam Integer id, @RequestParam(value = "selectResults") String subject, @RequestParam Integer result, Model model) {
        if(abitRepo.findById(id).isPresent()){
            switch (subject){
                case "Русский": {
                    if (rusResRepo.findByIdabit(abitRepo.findById(id).get()) == null) {
                        RusRes rusRes = new RusRes(abitRepo.findById(id).get(), result);
                        rusResRepo.save(rusRes);
                    }
                    break;
                }
                case "Математика" : {
                    if(mathResRepo.findByIdabit(abitRepo.findById(id).get()) == null) {
                        MathRes mathRes = new MathRes(abitRepo.findById(id).get(), result);
                        mathResRepo.save(mathRes);
                    }
                    break;
                }
                case "Физика" : {
                    if (physResRepo.findByIdabit(abitRepo.findById(id).get()) == null){
                        PhysRes physRes = new PhysRes(abitRepo.findById(id).get(), result);
                        physResRepo.save(physRes);
                    }
                    break;
                }
            }
        }
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }


    @GetMapping("/abit-service")
    public String showService() {
        return "abitService";
    }


}
