package com.service.domain;

import javax.persistence.*;

/**
 * Класс - сущность. Содержит информацию об абитуриентах (идентификатор, ФИО, вступительные испытания)
 * Соответствует таблице abits в базе данных
 * @author Алексей Бехтерев
 * @version 1.0
 */

@Entity
@Table(name = "abits")
public class Abit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idabit")
    private Integer idabit;

    @Column(name = "name")
    private String name;
    @Column(name = "subjects")
    private String subjects;

    /**
     * Стандартный конструктор, создающий экземпляр класса без входных параметров.
     */
    public Abit() {}

    /**
     * Конструктор принимающий на вход параметры без индентификатора.
     * @param name - ФИО
     * @param subjects - Вступительные испытания
     */
    public Abit(String name, String subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    /**
     * "Геттер" поля идентификатора, возвращает значение для конкретного пользователя
     * @return Integer
     */
    public Integer getIdabit() {
        return idabit;
    }

    /**
     * "Сеттер" поля идетификатора, заменяет существующее значение новым
     * @param idabit новое значение
     */
    public void setIdabit(Integer idabit) {
        this.idabit = idabit;
    }

    /**
     * "Геттер" поля имени(ФИО), возвращает значение для конкретного пользователя
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * "Сеттер" поля имени(ФИО), заменяет существующее значение новым
     * @param name - Новое значение
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * "Геттер" поля вступительных испытания, возвращает значение для конкретного пользователя
     * @return String
     */
    public String getSubjects() {
        return subjects;
    }

    /**
     * "Сеттер" поля вступительных испытаний, заменяет существующее значение новым
     * @param subjects - новое значение
     */
    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    /**
     * Метод преобразует объект класса Abit в строку
     * @return String
     */
    @Override
    public String toString() {
        return "Abit{" +
                "idabit=" + idabit +
                ", name='" + name + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
