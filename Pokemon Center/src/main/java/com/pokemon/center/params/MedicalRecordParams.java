package com.pokemon.center.params;

import java.sql.Timestamp;

public class MedicalRecordParams {
    private int medicalRecordId;
    private String diagnostic;
    private Timestamp followUpDate;
    private String observation;
    private int doctorId;
    private int pokemonPersonId;

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Timestamp getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Timestamp followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPokemonPersonId() {
        return pokemonPersonId;
    }

    public void setPokemonPersonId(int pokemonPersonId) {
        this.pokemonPersonId = pokemonPersonId;
    }

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }
}
