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

/**
 * Класс - контроллер. Часть реализуемой модели MVC
 * Отвечает за обработку действий пользователя через представление
 * @author Алексей Бехтерев
 * @version 1.0
 */

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

    /**
     * Метод возвращает страницу(emptyMapping) без указания конкретного пути(маппинга)
     * @return String
     */
    @GetMapping
    public String empty() {
        return "emptyMapping";
    }

    /**
     * Метод обрабатывает get-запрос по маппингу "/abits" и возвращет
     * страницу addTable со списком всех абитуриентов из базы данных
     * @param model - объект класса Model библиотеки springframework
     * @return String
     */
    @GetMapping("/abits")
    public String testDb(Model model) {
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }

    /**
     * Метод обрабатывает post-запрос по маппингу "/add-abit" и принимает входные параметры(ФИО, предметы)
     * для вызова статического метода addAbit(...) класса AbitService, добавляющего абитуриента в базу данных
     * После чего заполняется модель
     * Возвращается представление addTable
     * @param name - ФИО
     * @param subjects - предметы(вступительные испытания)
     * @param model - объект класса Model библиотеки springframework
     * @return String
     */
    @PostMapping("/add-abit")
    public String addAbit(@RequestParam String name, @RequestParam(value = "select") String subjects, Model model) {
        AbitService.addAbit(abitRepo, name, subjects);
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }

    /**
     * Метод обрабатывает post-запрос по маппингу "/add-results" и принимает входные параметры(id, предмет, результат)
     * для вызова метода addResults(...) соответствующих предмету сервисам, который создает
     * в таблице новую запись с результатами вступительных испытаний
     * Возвращается представление addTable
     * @param id - идентификатор абитуриента
     * @param subject - наименование вступительного испытания
     * @param result - результат (первичный балл)
     * @param model - объект класса Model библиотеки springframework
     * @return String
     */
    @PostMapping("/add-results")
    public String addResults(@RequestParam Integer id, @RequestParam(value = "selectResults") String subject, @RequestParam Integer result, Model model ) {
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
        model.addAttribute("abits", abitRepo.findAll());
        return "addTable";
    }

    /**
     * Метод обрабатывает get-запрос по маппингу "/abit-service" и возвращает представление(abitService)
     * @return String
     */
    @GetMapping("/abit-service")
    public String showService() {
        return "abitService";
    }

    /**
     * Метод обрабатывает post-запрос по маппингу "/view-results" и принимает входные параметры(предмет)
     * для вызова метода getResults(...) соответствующих предмету сервисов
     * Возвращается представление results
     * @param subject - предмет(вступительное испытание)
     * @param model1 - объекты класса
     * @param model2 - Model
     * @param model3 - библиотеки springframework
     * @return String
     */
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
