package com.service.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс - сущность. Содержит информацию о результах(первичном балле) по физике
 * для соответствующего идентификатора абитуриента
 * Соответсвует таблице physres базы данных
 * @author Алексей Бехтерев
 * @version 1.0
 */

@Entity
@Table(name = "physres")
public class PhysRes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phys_id")
    private Integer phys_id;

    @JoinColumn(name = "idabit")
    @OneToOne
    private Abit idabit;

    @Column(name = "result")
    private Integer result;

    public PhysRes() {
    }

    /**
     * Конструктор принимающий в параметрах в качестве идентификатора объект класса Abit
     * и результат
     * @param idabit - id абитуриента
     * @param result - результат
     */
    public PhysRes(Abit idabit, Integer result) {
        this.idabit = idabit;
        this.result = result;
    }

    /**
     * "Геттер" для поля индентификатора результата
     * @return Integer
     */
    public Integer getPhys_id() {
        return phys_id;
    }

    /**
     * "Сеттер" для поля идентификатора результата
     * @param phys_id - новое значение
     */
    public void setPhys_id(Integer phys_id) {
        this.phys_id = phys_id;
    }

    /**
     * "Геттер" для идентификатора абитуриента
     * @return Abit
     */
    public Abit getIdabit() {
        return idabit;
    }

    /**
     * "Сеттер" для идентификатора абитуриента
     * @param idabit - новое значение (объект Abit)
     */
    public void setIdabit(Abit idabit) {
        this.idabit = idabit;
    }

    /**
     * "Геттер" для поля результата
     * @return Integer
     */
    public Integer getResult() {
        return result;
    }

    /**
     * "Сеттер" для поля результата
     * @param result - новое значение
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * Метод преобразует объект класса в строку
     * @return String
     */
    @Override
    public String toString() {
        return "PhysRes{" +
                "phys_id=" + phys_id +
                ", idabit=" + idabit +
                ", result=" + result +
                '}';
    }
}
