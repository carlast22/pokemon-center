package com.pokemon.center.dao.repository;

import com.pokemon.center.dao.MedicalRecordSymptomDao;
import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.MedicalRecordSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MedicalRecordSymptomRepository extends JpaRepository<MedicalRecordSymptom, Integer>, JpaSpecificationExecutor<MedicalRecordSymptom> {
    MedicalRecordSymptom findMedicalRecordSymptomByMedRecSymId(int id);
    List<MedicalRecordSymptom> findMedicalRecordSymptomsByMedRecSymMedRecId(MedicalRecord medicalRecordId);
}
