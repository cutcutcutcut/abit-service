package com.service.domain;

import javax.persistence.*;
import java.io.Serializable;

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

    public MathRes(Abit idabit, Integer result) {
        this.idabit = idabit;
        this.result = result;
    }

    public Integer getMath_id() {
        return math_id;
    }

    public void setMath_id(Integer math_id) {
        this.math_id = math_id;
    }

    public Abit getIdabit() {
        return idabit;
    }

    public void setIdabit(Abit idabit) {
        this.idabit = idabit;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MathRes{" +
                "math_id=" + math_id +
                ", idabit=" + idabit +
                ", result=" + result +
                '}';
    }
}
