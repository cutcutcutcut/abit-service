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
    public String addResults(@RequestParam Integer id, @RequestParam(value = "selectResults") String subject, @RequestParam Integer result, Model model1 ) {
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
        model1.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }


    @GetMapping("/abit-service")
    public String showService() {
        return "abitService";
    }

    @PostMapping("/view-results")
    public String showResults(@RequestParam(value = "serviceSelect") String subject, Model model1, Model model2) {
        Iterable<Abit> abits = abitRepo.findAll();
        List<Abit> abitList = new ArrayList<>();
        for (Abit abit : abits) if (abit.getSubjects().contains(subject)) abitList.add(abit);
        model1.addAttribute("abitList", abitList);

        if (subject.equals("Русский")) {
            Iterable<RusRes> rusRes = rusResRepo.findAll();
            List<RusRes> rusList = new ArrayList<>();
            for (int i = 0; i < abitList.size(); i++) {
                for (RusRes res : rusRes) {
                    if(res.getIdabit().getIdabit() == abitList.get(i).getIdabit()) rusList.add(res);
                }
            }
            model2.addAttribute("results", rusList);
        }
        else if(subject.equals("Математика")) {
            Iterable<MathRes> mathRes = mathResRepo.findAll();
            List<MathRes> mathList = new ArrayList<>();
            for (int i = 0; i < abitList.size(); i++) {
                for (MathRes res : mathRes) {
                    if(res.getIdabit().getIdabit() == abitList.get(i).getIdabit()) mathList.add(res);
                }
            }
            model2.addAttribute("results", mathList);
        }
        else {
            Iterable<PhysRes> physRes = physResRepo.findAll();
            List<PhysRes> physList = new ArrayList<>();
            for (int i = 0; i < abitList.size(); i++) {
                for (PhysRes res : physRes) {
                    if(res.getIdabit().getIdabit() == abitList.get(i).getIdabit()) physList.add(res);
                }
            }
            model2.addAttribute("results", physList);
        }

        return "results";
    }


}
