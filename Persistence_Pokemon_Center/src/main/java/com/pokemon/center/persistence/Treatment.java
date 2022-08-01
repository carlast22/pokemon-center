package com.pokemon.center.persistence;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Treatment {
    private Integer treId;
    private String treName;
    private String treDescription;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tre_id")
    public Integer getTreId() {
        return treId;
    }

    public void setTreId(Integer treId) {
        this.treId = treId;
    }

    @Basic
    @Column(name = "tre_name")
    public String getTreName() {
        return treName;
    }

    public void setTreName(String treName) {
        this.treName = treName;
    }

    @Basic
    @Column(name = "tre_description")
    public String getTreDescription() {
        return treDescription;
    }

    public void setTreDescription(String treDescription) {
        this.treDescription = treDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return Objects.equals(treId, treatment.treId) && Objects.equals(treName, treatment.treName) && Objects.equals(treDescription, treatment.treDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treId, treName, treDescription);
    }
}
