package com.service.services;

import com.service.domain.Abit;
import com.service.repos.AbitRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - сервис. Содержит в себе бизнес-логику для работы с сущностью типа Abit
 * @author Алексей Бехтерев
 * @version 1.0
 */

@Service
public class AbitService {

    /**
     * Статический метод, обеспечивающий добавление новой записи в репозиторий с абитуриентами
     * @param abitRepo - интерфейс репозитория c abits
     * @param name - добавляемое ФИО
     * @param subjects - добавляемые вступительные испытания
     */
    public static void addAbit(AbitRepo abitRepo, String name, String subjects) {
        Abit abit = new Abit(name, subjects);
        abitRepo.save(abit);
    }

    /**
     * Статический метод по получению списка всех абитуриентов с
     * определенным параметром(вступительным испытанием)
     * @param subject - необходимый предмет
     * @param abitRepo - интерфейс репозитория abits
     * @return List<Abit>
     */
    public static List<Abit> getAbitsBySubject(String subject, AbitRepo abitRepo) {
        Iterable<Abit> abits = abitRepo.findAll();
        List<Abit> abitList = new ArrayList<>();
        for (Abit abit : abits) if (abit.getSubjects().contains(subject)) abitList.add(abit);
        return abitList;
    }
}
