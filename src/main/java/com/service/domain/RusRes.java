package com.service.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс - сущность. Содержит информацию о результах(первичном балле) по русскому
 * для соответствующего идентификатора абитуриента
 * Соответсвует таблице rusres базы данных
 * @author Алексей Бехтерев
 * @version 1.0
 */

@Entity
@Table(name = "rusres")
public class RusRes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rus_id")
    private Integer rus_id;

    @JoinColumn(name = "idabit")
    @OneToOne
    private Abit idabit;

    @Column(name = "result")
    private Integer result;

    public RusRes() {
    }

    /**
     * Конструктор принимающий в параметрах в качестве идентификатора объект класса Abit
     * и результат
     * @param idabit - id абитуриента
     * @param result - результат
     */
    public RusRes(Abit idabit, Integer result) {
        this.idabit = idabit;
        this.result = result;
    }

    /**
     * "Геттер" для поля индентификатора результата
     * @return Integer
     */
    public Integer getRus_id() {
        return rus_id;
    }

    /**
     * "Сеттер" для поля идентификатора результата
     * @param rus_id - новое значение
     */
    public void setRus_id(Integer rus_id) {
        this.rus_id = rus_id;
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
        return "RusRes{" +
                "rus_id=" + rus_id +
                ", idabit=" + idabit +
                ", result=" + result +
                '}';
    }
}

