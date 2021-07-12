package com.service.domain;

import javax.persistence.*;

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

    public Abit() {}

    public Abit(String name, String subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Integer getIdabit() {
        return idabit;
    }

    public void setIdabit(Integer idabit) {
        this.idabit = idabit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Abit{" +
                "idabit=" + idabit +
                ", name='" + name + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
