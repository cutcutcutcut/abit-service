package com.service.services;

import com.service.domain.Abit;
import com.service.repos.AbitRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbitService {

    public static void addAbit(AbitRepo abitRepo, String name, String subjects) {
        Abit abit = new Abit(name, subjects);
        abitRepo.save(abit);
    }

    public static List<Abit> getAbitsBySubject(String subject, AbitRepo abitRepo) {
        Iterable<Abit> abits = abitRepo.findAll();
        List<Abit> abitList = new ArrayList<>();
        for (Abit abit : abits) if (abit.getSubjects().contains(subject)) abitList.add(abit);
        return abitList;
    }
}
