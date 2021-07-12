package com.service.repos;

import com.service.domain.Abit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AbitRepo extends CrudRepository<Abit, Integer> {
    Optional<Abit> findById(Integer id);
}
