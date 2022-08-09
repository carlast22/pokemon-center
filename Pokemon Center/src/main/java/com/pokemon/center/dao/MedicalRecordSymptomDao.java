package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.MedicalRecordSymptomRepository;
import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.MedicalRecordSymptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalRecordSymptomDao {
    @Autowired
    MedicalRecordSymptomRepository medicalRecordSymptomRepository;

    public MedicalRecordSymptom createMedicalRecordSymptom(MedicalRecordSymptom medicalRecordSymptom) {
        return medicalRecordSymptomRepository.save(medicalRecordSymptom);
    }

    public List<MedicalRecordSymptom> createMedicalRecordSymptoms(List<MedicalRecordSymptom> medicalRecordSymptomList) {
        return medicalRecordSymptomRepository.saveAll(medicalRecordSymptomList);
    }

    public MedicalRecordSymptom findById(int medicalRecordSymptonId) {
        return medicalRecordSymptomRepository.findMedicalRecordSymptomByMedRecSymId(medicalRecordSymptonId);
    }

    public List<MedicalRecordSymptom> findByMedicalRecordId(MedicalRecord medicalRecordId) {
        return medicalRecordSymptomRepository.findMedicalRecordSymptomsByMedRecSymMedRecId(medicalRecordId);
    }
}
