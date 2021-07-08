package com.service.repos;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface AbitRepo extends CrudRepository<User, Integer> {
}
