package com.pokemon.center.service;

import com.pokemon.center.dao.MedicalRecordTreatmentDao;
import com.pokemon.center.params.MedicalRecordTreatmentParams;
import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.MedicalRecordTreatment;
import com.pokemon.center.persistence.Treatment;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordTreatmentService {

    @Autowired
    MedicalRecordTreatmentDao medicalRecordTreatmentDao;

    @Autowired
    TreatmentService treatmentService;

    public MedicalRecordTreatment create(MedicalRecordTreatmentParams medicalRecordTreatmentParams) {
        return medicalRecordTreatmentDao.create(medicalRecordTreatmentMapper(medicalRecordTreatmentParams));
    }

    public List<MedicalRecordTreatment> createMultiple(List<MedicalRecordTreatmentParams> medicalRecordTreatmentParams) {
        List<MedicalRecordTreatment> medicalRecordTreatmentList = new ArrayList<>();
        for (MedicalRecordTreatmentParams medicalRecordTreatmentParam : medicalRecordTreatmentParams) {
            medicalRecordTreatmentList.add(medicalRecordTreatmentMapper(medicalRecordTreatmentParam));
        }
        return medicalRecordTreatmentDao.createMultiple(medicalRecordTreatmentList);
    }

    private MedicalRecordTreatment medicalRecordTreatmentMapper(MedicalRecordTreatmentParams medicalRecordTreatmentParams) {
        if (medicalRecordTreatmentParams.getMedicine().trim().isEmpty()) {
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_MEDICAL_RECORD_TREATMENT_CREATION_PARAMS);
        }
        //TODO complete when ready
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedRecId(medicalRecordTreatmentParams.getMedicalRecordId());

        Treatment treatment = treatmentService.findById(medicalRecordTreatmentParams.getTreatmentId());

        MedicalRecordTreatment medicalRecordTreatment = new MedicalRecordTreatment();
        medicalRecordTreatment.setMedRecMedicine(medicalRecordTreatmentParams.getMedicine());
        medicalRecordTreatment.setMedRecTreTreId(treatment);
        medicalRecordTreatment.setMedRecTreMedRecId(medicalRecord);
        medicalRecordTreatment.setMedRecTreActive(true);

        return medicalRecordTreatment;
    }

    public MedicalRecordTreatment findById(int id) {
        MedicalRecordTreatment medicalRecordTreatment = medicalRecordTreatmentDao.findById(id);
        if (null == medicalRecordTreatment) {
            throw new PokemonCenterException(PokemonCenterResponse.MEDICAL_RECORD_TREATMENT_NOT_FOUND);
        }
        return medicalRecordTreatment;
    }

    public List<MedicalRecordTreatment> findByMedicalRecordId(int medicalRecordId) {

        //Todo complete when ready
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedRecId(medicalRecordId);
        return medicalRecordTreatmentDao.findByMedicalRecordId(medicalRecord);
    }
}
