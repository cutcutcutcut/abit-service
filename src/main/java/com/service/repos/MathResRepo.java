package com.service.repos;

import com.service.domain.Abit;
import com.service.domain.MathRes;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс наследуемый от интерфейса для общих операций CRUD с репозиторием mathres
 * @author Алексей Бехтерев
 * @version 1.0
 */

public interface MathResRepo extends CrudRepository<MathRes, Integer> {
    /**
     * Метод получает объект типа MathRes по идентификатору абитуриента(Abit)
     * @param idabit - экземпляр класса Abit, содержащий идентификатор
     * @return MathRes
     */
    MathRes findByIdabit(Abit idabit);
}
