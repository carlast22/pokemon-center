package com.pokemon.center.persistence;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Person {
    private Integer perId;
    private String perName;
    private String perLastName;
    private String perIdentification;
    private String perEmail;
    private Boolean perActive;
    private Timestamp perCreatedAt;
    private Date perDateOfBirth;
    private String perPassword;
    private Role perRolId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "per_id")
    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    @Basic
    @Column(name = "per_name")
    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    @Basic
    @Column(name = "per_last_name")
    public String getPerLastName() {
        return perLastName;
    }

    public void setPerLastName(String perLastName) {
        this.perLastName = perLastName;
    }

    @Basic
    @Column(name = "per_identification")
    public String getPerIdentification() {
        return perIdentification;
    }

    public void setPerIdentification(String perIdentification) {
        this.perIdentification = perIdentification;
    }

    @Basic
    @Column(name = "per_email")
    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    @Basic
    @Column(name = "per_active")
    public Boolean getPerActive() {
        return perActive;
    }

    public void setPerActive(Boolean perActive) {
        this.perActive = perActive;
    }

    @Basic
    @Column(name = "per_created_at")
    public Timestamp getPerCreatedAt() {
        return perCreatedAt;
    }

    public void setPerCreatedAt(Timestamp perCreatedAt) {
        this.perCreatedAt = perCreatedAt;
    }

    @Basic
    @Column(name = "per_date_of_birth")
    public Date getPerDateOfBirth() {
        return perDateOfBirth;
    }

    public void setPerDateOfBirth(Date perDateOfBirth) {
        this.perDateOfBirth = perDateOfBirth;
    }

    @Basic
    @Column(name = "per_password")
    public String getPerPassword() {
        return perPassword;
    }

    public void setPerPassword(String perPassword) {
        this.perPassword = perPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(perId, person.perId) && Objects.equals(perName, person.perName) && Objects.equals(perLastName, person.perLastName) && Objects.equals(perIdentification, person.perIdentification) && Objects.equals(perEmail, person.perEmail) && Objects.equals(perActive, person.perActive) && Objects.equals(perCreatedAt, person.perCreatedAt) && Objects.equals(perDateOfBirth, person.perDateOfBirth) && Objects.equals(perPassword, person.perPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perId, perName, perLastName, perIdentification, perEmail, perActive, perCreatedAt, perDateOfBirth, perPassword);
    }

    @ManyToOne
    @JoinColumn(name = "per_rol_id", referencedColumnName = "rol_id", nullable = false)
    public Role getPerRolId() {
        return perRolId;
    }

    public void setPerRolId(Role perRolId) {
        this.perRolId = perRolId;
    }
}
