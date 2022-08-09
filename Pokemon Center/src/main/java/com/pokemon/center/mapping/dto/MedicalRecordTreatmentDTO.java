package com.pokemon.center.mapping.dto;

import java.sql.Timestamp;

public class MedicalRecordTreatmentDTO {
    private int id;
    private boolean active;
    private Timestamp createdAt;
    private String medicine;
    private int medicalRecordId;
    private TreatmentDTO treatment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public TreatmentDTO getTreatment() {
        return treatment;
    }

    public void setTreatment(TreatmentDTO treatment) {
        this.treatment = treatment;
    }
}
