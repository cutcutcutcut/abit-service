package com.service.services;

import com.service.domain.RusRes;
import com.service.extraClasses.RusMap;
import com.service.repos.AbitRepo;
import com.service.repos.RusResRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RusResService {

    public static void addResults(AbitRepo abitRepo, RusResRepo rusResRepo, Integer id, Integer result) {
        if (rusResRepo.findByIdabit(abitRepo.findById(id).get()) == null && abitRepo.findById(id).get().getSubjects().contains("Русский")) {
            RusRes rusRes = new RusRes(abitRepo.findById(id).get(), result);
            rusResRepo.save(rusRes);
        }
    }

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
