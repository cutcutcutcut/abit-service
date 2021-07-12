package com.service.repos;

import com.service.domain.Abit;
import com.service.domain.RusRes;
import org.springframework.data.repository.CrudRepository;


public interface RusResRepo extends CrudRepository<RusRes, Integer> {
    RusRes findByIdabit(Abit idabit);
}
