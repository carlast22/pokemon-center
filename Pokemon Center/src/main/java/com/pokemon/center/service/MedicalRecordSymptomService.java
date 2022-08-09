package com.pokemon.center.service;

import com.pokemon.center.dao.MedicalRecordSymptomDao;
import com.pokemon.center.params.MedicalRecordSymptomParams;
import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.MedicalRecordSymptom;
import com.pokemon.center.persistence.Symptom;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordSymptomService {

    @Autowired
    SymptomService symptomService;

    @Autowired
    MedicalRecordSymptomDao medicalRecordSymptomDao;

    public MedicalRecordSymptom create(MedicalRecordSymptomParams medicalRecordSymptomParams) {
        return medicalRecordSymptomDao.createMedicalRecordSymptom(medicalRecordSymtomMapper(medicalRecordSymptomParams));
    }

    private MedicalRecordSymptom medicalRecordSymtomMapper(MedicalRecordSymptomParams medicalRecordSymptomParams) {
        //TODO validate medical record not null
        //MedicalRecord medicalRecord = medicalRecordService.findById(medicalRecordSymptomParams.getMedicalRecordId());

        Symptom symptom = symptomService.findById(medicalRecordSymptomParams.getSymptomId());
        MedicalRecordSymptom medicalRecordSymptom = new MedicalRecordSymptom();
        medicalRecordSymptom.setMedRecSymActive(true);
        medicalRecordSymptom.setMedRecSymDiagnosticsPeriod(medicalRecordSymptomParams.getDiagnosticPeriod());
        medicalRecordSymptom.setMedRecSymSymId(symptom);
        //TODO remove when ready
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedRecId(1);
        medicalRecordSymptom.setMedRecSymMedRecId(medicalRecord);
        return medicalRecordSymptom;
    }

    public List<MedicalRecordSymptom> createList(List<MedicalRecordSymptomParams> medicalRecordSymptomParamsList) {
        List<MedicalRecordSymptom> medicalRecordSymptomList = new ArrayList<>();
        for (MedicalRecordSymptomParams medicalRecordSymptomParams : medicalRecordSymptomParamsList) {
            medicalRecordSymptomList.add(medicalRecordSymtomMapper(medicalRecordSymptomParams));
        }
        return medicalRecordSymptomDao.createMedicalRecordSymptoms(medicalRecordSymptomList);
    }

    public MedicalRecordSymptom findById(int medicalRecordSymptonId) {
        MedicalRecordSymptom medicalRecordSymptom = medicalRecordSymptomDao.findById(medicalRecordSymptonId);
        if (null == medicalRecordSymptom) {
            throw new PokemonCenterException(PokemonCenterResponse.MEDICAL_RECORD_SYMPTOM_NOT_FOUND);
        }
        return medicalRecordSymptom;
    }

    public List<MedicalRecordSymptom> findByMedicalRecordId(int medicalRecordId) {
        //TODO validate medical record not null
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedRecId(medicalRecordId);

        return medicalRecordSymptomDao.findByMedicalRecordId(medicalRecord);
    }
}
