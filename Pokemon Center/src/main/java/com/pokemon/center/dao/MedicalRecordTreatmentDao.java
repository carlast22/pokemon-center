package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.MedicalRecordTreatmentRepository;
import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.MedicalRecordTreatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalRecordTreatmentDao {

    @Autowired
    MedicalRecordTreatmentRepository medicalRecordTreatmentRepository;

    public MedicalRecordTreatment create(MedicalRecordTreatment medicalRecordTreatment) {
        return medicalRecordTreatmentRepository.save(medicalRecordTreatment);
    }

    public List<MedicalRecordTreatment> createMultiple(List<MedicalRecordTreatment> medicalRecordTreatmentList) {
        return medicalRecordTreatmentRepository.saveAll(medicalRecordTreatmentList);
    }

    public MedicalRecordTreatment findById(int id) {
        return medicalRecordTreatmentRepository.findMedicalRecordTreatmentByMedRecTreId(id);
    }

    public List<MedicalRecordTreatment> findByMedicalRecordId(MedicalRecord medicalRecord) {
        return medicalRecordTreatmentRepository.findMedicalRecordTreatmentsByMedRecTreMedRecId(medicalRecord);
    }
}
