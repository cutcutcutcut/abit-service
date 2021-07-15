package com.service.repos;

import com.service.domain.Abit;
import com.service.domain.RusRes;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс наследуемый от интерфейса для общих операций CRUD с репозиторием rusres
 * @author Алексей Бехтерев
 * @version 1.0
 */
public interface RusResRepo extends CrudRepository<RusRes, Integer> {
    /**
     * Метод получает объект типа RusRes по идентификатору абитуриента(Abit)
     * @param idabit - экземпляр класса Abit, содержащий идентификатор
     * @return RusRes
     */
    RusRes findByIdabit(Abit idabit);
}
