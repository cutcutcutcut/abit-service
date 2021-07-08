package com.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //uuid later

    private String name;
    private String subjects;

    public Abit() {}

    public Abit(String name, String subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
