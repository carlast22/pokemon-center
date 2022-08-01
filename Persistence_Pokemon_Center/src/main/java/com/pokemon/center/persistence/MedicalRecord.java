package com.pokemon.center.persistence;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Medical_Record", schema = "pokemon_center")
public class MedicalRecord {
    private Integer medRecId;
    private Timestamp medRecArrivalDate;
    private String medRecDiagnostic;
    private Timestamp medRecFollowUpDate;
    private Timestamp medRecEndDate;
    private Person medRecPerId;
    private PokemonPerson medRecPokPerId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "med_rec_id")
    public Integer getMedRecId() {
        return medRecId;
    }

    public void setMedRecId(Integer medRecId) {
        this.medRecId = medRecId;
    }

    @Basic
    @Column(name = "med_rec_arrival_date")
    public Timestamp getMedRecArrivalDate() {
        return medRecArrivalDate;
    }

    public void setMedRecArrivalDate(Timestamp medRecArrivalDate) {
        this.medRecArrivalDate = medRecArrivalDate;
    }

    @Basic
    @Column(name = "med_rec_diagnostic")
    public String getMedRecDiagnostic() {
        return medRecDiagnostic;
    }

    public void setMedRecDiagnostic(String medRecDiagnostic) {
        this.medRecDiagnostic = medRecDiagnostic;
    }

    @Basic
    @Column(name = "med_rec_follow_up_date")
    public Timestamp getMedRecFollowUpDate() {
        return medRecFollowUpDate;
    }

    public void setMedRecFollowUpDate(Timestamp medRecFollowUpDate) {
        this.medRecFollowUpDate = medRecFollowUpDate;
    }

    @Basic
    @Column(name = "med_rec_end_date")
    public Timestamp getMedRecEndDate() {
        return medRecEndDate;
    }

    public void setMedRecEndDate(Timestamp medRecEndDate) {
        this.medRecEndDate = medRecEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalRecord that = (MedicalRecord) o;
        return Objects.equals(medRecId, that.medRecId) && Objects.equals(medRecArrivalDate, that.medRecArrivalDate) && Objects.equals(medRecDiagnostic, that.medRecDiagnostic) && Objects.equals(medRecFollowUpDate, that.medRecFollowUpDate) && Objects.equals(medRecEndDate, that.medRecEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medRecId, medRecArrivalDate, medRecDiagnostic, medRecFollowUpDate, medRecEndDate);
    }

    @ManyToOne
    @JoinColumn(name = "med_rec_per_id", referencedColumnName = "per_id", nullable = false)
    public Person getMedRecPerId() {
        return medRecPerId;
    }

    public void setMedRecPerId(Person medRecPerId) {
        this.medRecPerId = medRecPerId;
    }

    @ManyToOne
    @JoinColumn(name = "med_rec_pok_per_id", referencedColumnName = "pok_per_id", nullable = false)
    public PokemonPerson getMedRecPokPerId() {
        return medRecPokPerId;
    }

    public void setMedRecPokPerId(PokemonPerson medRecPokPerId) {
        this.medRecPokPerId = medRecPokPerId;
    }
}
