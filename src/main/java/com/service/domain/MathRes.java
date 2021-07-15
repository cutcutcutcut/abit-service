package com.service.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс - сущность. Содержит информацию о результах(первичном балле) по математике
 * для соответствующего идентификатора абитуриента
 * Соответсвует таблице mathres базы данных
 * @author Алексей Бехтерев
 * @version 1.0
 */

@Entity
@Table(name = "mathres")
public class MathRes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "math_id")
    private Integer math_id;

    @JoinColumn(name = "idabit")
    @OneToOne
    private Abit idabit;

    @Column(name = "result")
    private Integer result;

    public MathRes() {
    }

    /**
     * Конструктор принимающий в параметрах в качестве идентификатора объект класса Abit
     * и результат
     * @param idabit - id абитуриента
     * @param result - результат
     */
    public MathRes(Abit idabit, Integer result) {
        this.idabit = idabit;
        this.result = result;
    }

    /**
     * "Геттер" для поля индентификатора результата
     * @return Integer
     */
    public Integer getMath_id() {
        return math_id;
    }

    /**
     * "Сеттер" для поля идентификатора результата
     * @param math_id - новое значение
     */
    public void setMath_id(Integer math_id) {
        this.math_id = math_id;
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
        return "MathRes{" +
                "math_id=" + math_id +
                ", idabit=" + idabit +
                ", result=" + result +
                '}';
    }
}
