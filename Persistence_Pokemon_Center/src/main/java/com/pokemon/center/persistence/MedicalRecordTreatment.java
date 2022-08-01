package com.pokemon.center.persistence;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Medical_Record_Treatment", schema = "pokemon_center", catalog = "")
public class MedicalRecordTreatment {
    private Integer medRecTreId;
    private Timestamp medRecTreCreatedAt;
    private Boolean medRecTreActive;
    private Treatment medRecTreTreId;
    private MedicalRecord medRecTreMedRecId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "med_rec_tre_id")
    public Integer getMedRecTreId() {
        return medRecTreId;
    }

    public void setMedRecTreId(Integer medRecTreId) {
        this.medRecTreId = medRecTreId;
    }

    @Basic
    @Column(name = "med_rec_tre_created_at")
    public Timestamp getMedRecTreCreatedAt() {
        return medRecTreCreatedAt;
    }

    public void setMedRecTreCreatedAt(Timestamp medRecTreCreatedAt) {
        this.medRecTreCreatedAt = medRecTreCreatedAt;
    }

    @Basic
    @Column(name = "med_rec_tre_active")
    public Boolean getMedRecTreActive() {
        return medRecTreActive;
    }

    public void setMedRecTreActive(Boolean medRecTreActive) {
        this.medRecTreActive = medRecTreActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalRecordTreatment that = (MedicalRecordTreatment) o;
        return Objects.equals(medRecTreId, that.medRecTreId) && Objects.equals(medRecTreCreatedAt, that.medRecTreCreatedAt) && Objects.equals(medRecTreActive, that.medRecTreActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medRecTreId, medRecTreCreatedAt, medRecTreActive);
    }

    @ManyToOne
    @JoinColumn(name = "med_rec_tre_tre_id", referencedColumnName = "tre_id", nullable = false)
    public Treatment getMedRecTreTreId() {
        return medRecTreTreId;
    }

    public void setMedRecTreTreId(Treatment medRecTreTreId) {
        this.medRecTreTreId = medRecTreTreId;
    }

    @ManyToOne
    @JoinColumn(name = "med_rec_tre_med_rec_id", referencedColumnName = "med_rec_id", nullable = false)
    public MedicalRecord getMedRecTreMedRecId() {
        return medRecTreMedRecId;
    }

    public void setMedRecTreMedRecId(MedicalRecord medRecTreMedRecId) {
        this.medRecTreMedRecId = medRecTreMedRecId;
    }
}
