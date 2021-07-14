package com.service.services;

import com.service.domain.PhysRes;
import com.service.extraClasses.PhysMap;
import com.service.repos.AbitRepo;
import com.service.repos.PhysResRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhysResService {
    public static void addResults(AbitRepo abitRepo, PhysResRepo physResRepo, Integer id, Integer result) {
        if (physResRepo.findByIdabit(abitRepo.findById(id).get()) == null && abitRepo.findById(id).get().getSubjects().contains("Физика")){
            PhysRes physRes = new PhysRes(abitRepo.findById(id).get(), result);
            physResRepo.save(physRes);
        }
    }

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
