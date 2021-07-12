package com.service.domain;

import javax.persistence.*;
import java.io.Serializable;

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

    public PhysRes(Abit idabit, Integer result) {
        this.idabit = idabit;
        this.result = result;
    }

    public Integer getPhys_id() {
        return phys_id;
    }

    public void setPhys_id(Integer phys_id) {
        this.phys_id = phys_id;
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
        return "PhysRes{" +
                "phys_id=" + phys_id +
                ", idabit=" + idabit +
                ", result=" + result +
                '}';
    }
}
