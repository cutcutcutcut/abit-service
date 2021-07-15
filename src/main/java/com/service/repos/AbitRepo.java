package com.service.repos;

import com.service.domain.Abit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Интерфейс наследуемый от интерфейса для общих операций CRUD с репозиторием abits
 * @author Алексей Бехтерев
 * @version 1.0
 */

public interface AbitRepo extends CrudRepository<Abit, Integer> {
    /**
     * Метод получает объект типа Abit по его идентификатору
     * @param id - идентификатор для поиска
     * @return Optional<Abit>
     */
    Optional<Abit> findById(Integer id);
}
