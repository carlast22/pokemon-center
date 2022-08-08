package com.pokemon.center.params;

public class MedicalRecordSymptomParams {

    private double diagnosticPeriod;
    private int medicalRecordId;
    private int symptomId;

    public void setDiagnosticPeriod(double diagnosticPeriod) {
        this.diagnosticPeriod = diagnosticPeriod;
    }

    public double getDiagnosticPeriod() {
        return diagnosticPeriod;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public int getSymptomId() {
        return symptomId;
    }
}
