package com.service.services;

import com.service.domain.MathRes;
import com.service.extraClasses.MathMap;
import com.service.repos.AbitRepo;
import com.service.repos.MathResRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MathResService {
    public static void addResults(AbitRepo abitRepo, MathResRepo mathResRepo, Integer id, Integer result) {
        if(mathResRepo.findByIdabit(abitRepo.findById(id).get()) == null && abitRepo.findById(id).get().getSubjects().contains("Математика")) {
            MathRes mathRes = new MathRes(abitRepo.findById(id).get(), result);
            mathResRepo.save(mathRes);
        }
    }

    public static List<MathRes> getResults(AbitRepo abitRepo, MathResRepo mathResRepo, String subject, List<Integer> resValues) {
        Iterable<MathRes> mathRes = mathResRepo.findAll();
        List<MathRes> mathList = new ArrayList<>();
        for (int i = 0; i < AbitService.getAbitsBySubject(subject, abitRepo).size(); i++) {
            for (MathRes res : mathRes) {
                if(res.getIdabit().getIdabit() == AbitService.getAbitsBySubject(subject, abitRepo).get(i).getIdabit()) {
                    mathList.add(res);
                    resValues.add(MathMap.getRes(res.getResult()));
                }
            }
        }
        return mathList;
    }
}
