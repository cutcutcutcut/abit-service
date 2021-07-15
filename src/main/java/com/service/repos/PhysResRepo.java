package com.service.repos;

import com.service.domain.Abit;
import com.service.domain.PhysRes;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс наследуемый от интерфейса для общих операций CRUD с репозиторием physres
 * @author Алексей Бехтерев
 * @version 1.0
 */
public interface PhysResRepo extends CrudRepository<PhysRes, Integer> {
    /**
     * Метод получает объект типа PhysRes по идентификатору абитуриента(Abit)
     * @param idabit - экземпляр класса Abit, содержащий идентификатор
     * @return PhysRes
     */
    PhysRes findByIdabit(Abit idabit);
}
