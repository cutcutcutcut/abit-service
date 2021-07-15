package com.service.services;

import com.service.domain.PhysRes;
import com.service.extraClasses.PhysMap;
import com.service.repos.AbitRepo;
import com.service.repos.PhysResRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - сервис. Содержит в себе бизнес-логику для работы с сущностью типа PhysRes
 * @author Алексей Бехтерев
 * @version 1.0
 */

@Service
public class PhysResService {
    /**
     * Статический метод, обеспечивающий добавление абитуриенту
     * результатов(первичных баллов) по физике в соответствии с полученным идентификатором
     * @param abitRepo - интерфейс репозитория abits
     * @param physResRepo - интерфейс репозитория physres
     * @param id - идентификатор абитуриента
     * @param result - первичный балл(результат)
     */
    public static void addResults(AbitRepo abitRepo, PhysResRepo physResRepo, Integer id, Integer result) {
        if (physResRepo.findByIdabit(abitRepo.findById(id).get()) == null && abitRepo.findById(id).get().getSubjects().contains("Физика")){
            PhysRes physRes = new PhysRes(abitRepo.findById(id).get(), result);
            physResRepo.save(physRes);
        }
    }

    /**
     * Статический метод для получения списка результатов по физике, упорядоченный
     * в соответствии со списком, полученным из репозитория с абитуриентами с соответствующим
     * вступительным испытанием
     * @param abitRepo - интерфейс репозитория abits
     * @param physResRepo - интерфейс репозитория physres
     * @param subject - предмет
     * @param resValues - список с преобразованными баллами(с использованием Map)
     * @return List<PhysRes>
     */
    public static List<PhysRes> getResults(AbitRepo abitRepo, PhysResRepo physResRepo, String subject, List<Integer> resValues) {
        Iterable<PhysRes> physRes = physResRepo.findAll();
        List<PhysRes> physList = new ArrayList<>();
        for (int i = 0; i < AbitService.getAbitsBySubject(subject, abitRepo).size(); i++) {
            for (PhysRes res : physRes) {
                if(res.getIdabit().getIdabit() == AbitService.getAbitsBySubject(subject, abitRepo).get(i).getIdabit()) {
                    physList.add(res);
                    resValues.add(PhysMap.getRes(res.getResult()));
                }
            }
        }
        return physList;
    }
}
