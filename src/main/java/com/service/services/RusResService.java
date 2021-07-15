package com.service.services;

import com.service.domain.RusRes;
import com.service.extraClasses.RusMap;
import com.service.repos.AbitRepo;
import com.service.repos.RusResRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - сервис. Содержит в себе бизнес-логику для работы с сущностью типа RusRes
 * @author Алексей Бехтерев
 * @version 1.0
 */

@Service
public class RusResService {

    /**
     * Статический метод, обеспечивающий добавление абитуриенту
     * результатов(первичных баллов) по русскому языку в соответствии с полученным идентификатором
     * @param abitRepo - интерфейс репозитория abits
     * @param rusResRepo - интерфейс репозитория rusres
     * @param id - идентификатор абитуриента
     * @param result - первичный балл(результат)
     */
    public static void addResults(AbitRepo abitRepo, RusResRepo rusResRepo, Integer id, Integer result) {
        if (rusResRepo.findByIdabit(abitRepo.findById(id).get()) == null && abitRepo.findById(id).get().getSubjects().contains("Русский")) {
            RusRes rusRes = new RusRes(abitRepo.findById(id).get(), result);
            rusResRepo.save(rusRes);
        }
    }

    /**
     * Статический метод для получения списка результатов по русскому языку, упорядоченный
     * в соответствии со списком, полученным из репозитория с абитуриентами с соответствующим
     * вступительным испытанием
     * @param abitRepo - интерфейс репозитория abits
     * @param rusResRepo - интерфейс репозитория rusres
     * @param subject - предмет
     * @param resValues - список с преобразованными баллами(с использованием Map)
     * @return List<RusRes>
     */
    public static List<RusRes> getResults(AbitRepo abitRepo, RusResRepo rusResRepo, String subject, List<Integer> resValues) {
        Iterable<RusRes> rusRes = rusResRepo.findAll();
        List<RusRes> rusList = new ArrayList<>();
        for (int i = 0; i < AbitService.getAbitsBySubject(subject, abitRepo).size(); i++) {
            for (RusRes res : rusRes) {
                if(res.getIdabit().getIdabit() == AbitService.getAbitsBySubject(subject, abitRepo).get(i).getIdabit()) {
                    rusList.add(res);
                    resValues.add(RusMap.getRes(res.getResult()));
                }
            }
        }
        return rusList;
    }
}
