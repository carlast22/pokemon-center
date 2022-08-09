package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.MedicalRecordRepository;
import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.Person;
import com.pokemon.center.persistence.PokemonPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalRecordDao {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;


    public MedicalRecord create(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord update(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord findById(int medicalRecordId) {
        return medicalRecordRepository.findMedicalRecordByMedRecId(medicalRecordId);
    }

    public List<MedicalRecord> findByDoctorId(Person doctor) {
        return medicalRecordRepository.findMedicalRecordsByMedRecPerId(doctor);
    }

    public List<MedicalRecord> findByPokemonPersonId(PokemonPerson pokemonPerson) {
        return medicalRecordRepository.findMedicalRecordsByMedRecPokPerId(pokemonPerson);
    }
}
