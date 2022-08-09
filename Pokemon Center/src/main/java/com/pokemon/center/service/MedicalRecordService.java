package com.pokemon.center.service;

import com.pokemon.center.dao.MedicalRecordDao;
import com.pokemon.center.params.MedicalRecordParams;
import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.Person;
import com.pokemon.center.persistence.PokemonPerson;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    MedicalRecordDao medicalRecordDao;

    @Autowired
    PersonService personService;

    public MedicalRecord create(MedicalRecordParams medicalRecordParams) {
        Person doctor = personService.findById(medicalRecordParams.getDoctorId());
        //TOOD change when ready
        PokemonPerson pokemonPerson = new PokemonPerson();
        pokemonPerson.setPokPerId(1);

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedRecDiagnostic(medicalRecordParams.getDiagnostic());
        medicalRecord.setMedRecFollowUpDate(medicalRecordParams.getFollowUpDate());
        medicalRecord.setMedRecObservation(medicalRecordParams.getObservation());
        medicalRecord.setMedRecPerId(doctor);
        medicalRecord.setMedRecPokPerId(pokemonPerson);
        //todo must be automatic
        medicalRecord.setMedRecArrivalDate(new Timestamp(System.currentTimeMillis()));

        return medicalRecordDao.create(medicalRecord);


    }

    public MedicalRecord update(MedicalRecordParams medicalRecordParams) {

        MedicalRecord medicalRecord = findById(medicalRecordParams.getMedicalRecordId());

        medicalRecord.setMedRecDiagnostic(medicalRecordParams.getDiagnostic());
        medicalRecord.setMedRecFollowUpDate(medicalRecordParams.getFollowUpDate());
        medicalRecord.setMedRecObservation(medicalRecordParams.getObservation());

        return medicalRecordDao.update(medicalRecord);
    }

    public MedicalRecord findById(int medicalRecordId) {
        MedicalRecord medicalRecord = medicalRecordDao.findById(medicalRecordId);
        if (null == medicalRecord) {
            throw new PokemonCenterException(PokemonCenterResponse.MEDICAL_RECORD_NOT_FOUND);
        }
        return medicalRecord;
    }

    public List<MedicalRecord> findByDoctorId(int doctorId) {
        Person doctor = personService.findById(doctorId);
        return medicalRecordDao.findByDoctorId(doctor);
    }

    public List<MedicalRecord> findByPokemonPersonId(int pokemonPersonId) {
        //Todo change when ready
        PokemonPerson pokemonPerson = new PokemonPerson();
        pokemonPerson.setPokPerId(pokemonPersonId);
        return medicalRecordDao.findByPokemonPersonId(pokemonPerson);
    }

    public MedicalRecord closeMedicalRecord(int medicalRecordId) {
        MedicalRecord medicalRecord = findById(medicalRecordId);
        medicalRecord.setMedRecEndDate(new Timestamp(System.currentTimeMillis()));
        return medicalRecordDao.update(medicalRecord);
    }
}
