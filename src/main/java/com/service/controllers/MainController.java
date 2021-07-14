package com.service.controllers;

import com.service.repos.AbitRepo;
import com.service.repos.MathResRepo;
import com.service.repos.PhysResRepo;
import com.service.repos.RusResRepo;
import com.service.services.AbitService;
import com.service.services.MathResService;
import com.service.services.PhysResService;
import com.service.services.RusResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
    public String greeting() {
        return "emptyMapping";
    }

    @GetMapping("/abits")
    public String testDb(Model model) {
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }

    @PostMapping("/add-abit")
    public String addAbit(@RequestParam String name, @RequestParam(value = "select") String subjects, Model model) {
        AbitService.addAbit(abitRepo, name, subjects);
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }

    @PostMapping("/add-results")
    public String addResults(@RequestParam Integer id, @RequestParam(value = "selectResults") String subject, @RequestParam Integer result, Model model1 ) {
        if(abitRepo.findById(id).isPresent()){
            switch (subject){
                case "Русский": {
                    RusResService.addResults(abitRepo, rusResRepo, id, result);
                    break;
                }
                case "Математика" : {
                    MathResService.addResults(abitRepo, mathResRepo, id, result);
                    break;
                }
                case "Физика" : {
                    PhysResService.addResults(abitRepo, physResRepo, id, result);
                    break;
                }
            }
        }
        model1.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }


    @GetMapping("/abit-service")
    public String showService() {
        return "abitService";
    }

    @PostMapping("/view-results")
    public String showResults(@RequestParam(value = "serviceSelect") String subject, Model model1, Model model2, Model model3) {
        List<Integer> resValues = new ArrayList<>();
        model1.addAttribute("abitList", AbitService.getAbitsBySubject(subject, abitRepo));

        if (subject.equals("Русский")) {
            model2.addAttribute("results", RusResService.getResults(abitRepo, rusResRepo, subject, resValues));
        }
        else if(subject.equals("Математика")) {
            model2.addAttribute("results", MathResService.getResults(abitRepo, mathResRepo, subject, resValues));
        }
        else {
            model2.addAttribute("results", PhysResService.getResults(abitRepo, physResRepo, subject, resValues));
        }
        model3.addAttribute("finalResults", resValues);
        return "results";
    }


}
