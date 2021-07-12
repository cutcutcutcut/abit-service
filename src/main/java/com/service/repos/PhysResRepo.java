package com.service.repos;

import com.service.domain.Abit;
import com.service.domain.PhysRes;
import org.springframework.data.repository.CrudRepository;


public interface PhysResRepo extends CrudRepository<PhysRes, Integer> {
    PhysRes findByIdabit(Abit idabit);
}
