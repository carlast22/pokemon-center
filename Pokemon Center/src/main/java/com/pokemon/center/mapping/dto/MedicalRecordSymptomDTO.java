package com.pokemon.center.mapping.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class MedicalRecordSymptomDTO {
    private int id;
    private boolean active;
    private Timestamp createdAt;
    private double symptomPeriod;
    private int medicalRecordId;
    private SymptomDTO symptomDTO;

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

    public double getSymptomPeriod() {
        return symptomPeriod;
    }

    public void setSymptomPeriod(double symptomPeriod) {
        this.symptomPeriod = symptomPeriod;
    }

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public SymptomDTO getSymptomDTO() {
        return symptomDTO;
    }

    public void setSymptomDTO(SymptomDTO symptomDTO) {
        this.symptomDTO = symptomDTO;
    }
}
