package com.pokemon.center.persistence;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Symptom {
    private Integer symId;
    private String symName;
    private String symDescription;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sym_id")
    public Integer getSymId() {
        return symId;
    }

    public void setSymId(Integer symId) {
        this.symId = symId;
    }

    @Basic
    @Column(name = "sym_name")
    public String getSymName() {
        return symName;
    }

    public void setSymName(String symName) {
        this.symName = symName;
    }

    @Basic
    @Column(name = "sym_description")
    public String getSymDescription() {
        return symDescription;
    }

    public void setSymDescription(String symDescription) {
        this.symDescription = symDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptom symptom = (Symptom) o;
        return Objects.equals(symId, symptom.symId) && Objects.equals(symName, symptom.symName) && Objects.equals(symDescription, symptom.symDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symId, symName, symDescription);
    }
}
