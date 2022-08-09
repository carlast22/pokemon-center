package com.pokemon.center.dao.repository;

import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.MedicalRecordTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MedicalRecordTreatmentRepository extends JpaRepository<MedicalRecordTreatment, Integer> {
    MedicalRecordTreatment findMedicalRecordTreatmentByMedRecTreId(int id);
    List<MedicalRecordTreatment> findMedicalRecordTreatmentsByMedRecTreMedRecId(MedicalRecord medicalRecord);
}
