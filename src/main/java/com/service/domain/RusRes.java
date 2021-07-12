package com.service.domain;

import javax.persistence.*;
import java.io.Serializable;

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

    public RusRes(Abit idabit, Integer result) {
        this.idabit = idabit;
        this.result = result;
    }

    public Integer getRus_id() {
        return rus_id;
    }

    public void setRus_id(Integer rus_id) {
        this.rus_id = rus_id;
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
        return "RusRes{" +
                "rus_id=" + rus_id +
                ", idabit=" + idabit +
                ", result=" + result +
                '}';
    }
}

