package com.pokemon.center.persistence;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Medical_Record_Symptom", schema = "pokemon_center", catalog = "")
public class MedicalRecordSymptom {
    private Integer medRecSymId;
    private Boolean medRecSymActive;
    private Timestamp medRecSymCreatedAt;
    private Double medRecSymDiagnosticsPeriod;
    private Symptom medRecSymSymId;
    private MedicalRecord medRecSymMedRecId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "med_rec_sym_id")
    public Integer getMedRecSymId() {
        return medRecSymId;
    }

    public void setMedRecSymId(Integer medRecSymId) {
        this.medRecSymId = medRecSymId;
    }

    @Basic
    @Column(name = "med_rec_sym_active")
    public Boolean getMedRecSymActive() {
        return medRecSymActive;
    }

    public void setMedRecSymActive(Boolean medRecSymActive) {
        this.medRecSymActive = medRecSymActive;
    }

    @Basic
    @Column(name = "med_rec_sym_created_at")
    public Timestamp getMedRecSymCreatedAt() {
        return medRecSymCreatedAt;
    }

    public void setMedRecSymCreatedAt(Timestamp medRecSymCreatedAt) {
        this.medRecSymCreatedAt = medRecSymCreatedAt;
    }

    @Basic
    @Column(name = "med_rec_sym_diagnostics_period")
    public Double getMedRecSymDiagnosticsPeriod() {
        return medRecSymDiagnosticsPeriod;
    }

    public void setMedRecSymDiagnosticsPeriod(Double medRecSymDiagnosticsPeriod) {
        this.medRecSymDiagnosticsPeriod = medRecSymDiagnosticsPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalRecordSymptom that = (MedicalRecordSymptom) o;
        return Objects.equals(medRecSymId, that.medRecSymId) && Objects.equals(medRecSymActive, that.medRecSymActive) && Objects.equals(medRecSymCreatedAt, that.medRecSymCreatedAt) && Objects.equals(medRecSymDiagnosticsPeriod, that.medRecSymDiagnosticsPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medRecSymId, medRecSymActive, medRecSymCreatedAt, medRecSymDiagnosticsPeriod);
    }

    @ManyToOne
    @JoinColumn(name = "med_rec_sym_sym_id", referencedColumnName = "sym_id", nullable = false)
    public Symptom getMedRecSymSymId() {
        return medRecSymSymId;
    }

    public void setMedRecSymSymId(Symptom medRecSymSymId) {
        this.medRecSymSymId = medRecSymSymId;
    }

    @ManyToOne
    @JoinColumn(name = "med_rec_sym_med_rec_id", referencedColumnName = "med_rec_id", nullable = false)
    public MedicalRecord getMedRecSymMedRecId() {
        return medRecSymMedRecId;
    }

    public void setMedRecSymMedRecId(MedicalRecord medRecSymMedRecId) {
        this.medRecSymMedRecId = medRecSymMedRecId;
    }
}
