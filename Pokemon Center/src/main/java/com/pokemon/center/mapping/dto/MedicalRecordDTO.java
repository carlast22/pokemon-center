package com.pokemon.center.mapping.dto;

import com.pokemon.center.persistence.Pokemon;
import com.pokemon.center.persistence.PokemonPerson;

import java.sql.Timestamp;

public class MedicalRecordDTO {

    private int medicalRecordId;
    private Timestamp arrivalDate;
    private String diagnostic;
    private String followUpDate;
    private Timestamp endDate;
    private String observation;

    private PersonDTO doctor;
    private PersonDTO trainer;


    private PokemonPersonDTO trainerPokemon;
    private PokemonDTO pokemon;

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public PersonDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(PersonDTO doctor) {
        this.doctor = doctor;
    }

    public PersonDTO getTrainer() {
        return trainer;
    }

    public void setTrainer(PersonDTO trainer) {
        this.trainer = trainer;
    }

    public PokemonPersonDTO getTrainerPokemon() {
        return trainerPokemon;
    }

    public void setTrainerPokemon(PokemonPersonDTO trainerPokemon) {
        this.trainerPokemon = trainerPokemon;
    }

    public PokemonDTO getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonDTO pokemon) {
        this.pokemon = pokemon;
    }
}
