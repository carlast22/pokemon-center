package com.pokemon.center.persistence;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Role {
    private Integer rolId;
    private String rolName;
    private String rolDescription;
    private Boolean rolActive;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rol_id")
    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Basic
    @Column(name = "rol_name")
    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    @Basic
    @Column(name = "rol_description")
    public String getRolDescription() {
        return rolDescription;
    }

    public void setRolDescription(String rolDescription) {
        this.rolDescription = rolDescription;
    }

    @Basic
    @Column(name = "rol_active")
    public Boolean getRolActive() {
        return rolActive;
    }

    public void setRolActive(Boolean rolActive) {
        this.rolActive = rolActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(rolId, role.rolId) && Objects.equals(rolName, role.rolName) && Objects.equals(rolDescription, role.rolDescription) && Objects.equals(rolActive, role.rolActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, rolName, rolDescription, rolActive);
    }
}
