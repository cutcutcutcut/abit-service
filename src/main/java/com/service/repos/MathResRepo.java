package com.service.repos;

import com.service.domain.Abit;
import com.service.domain.MathRes;
import org.springframework.data.repository.CrudRepository;


public interface MathResRepo extends CrudRepository<MathRes, Integer> {
    MathRes findByIdabit(Abit idabit);
}
