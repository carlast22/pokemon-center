package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.MedicalRecordSymptomDTO;
import com.pokemon.center.params.MedicalRecordSymptomParams;
import com.pokemon.center.persistence.MedicalRecordSymptom;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import com.pokemon.center.utilities.response.ResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MedicalRecordSymptomControllerTest {
    @Autowired
    MedicalRecordSymptomController medicalRecordSymptomController;

    @Test
    void whenValidParamsForSymptomDetailCreationAreSubmittedThenARecordShouldBeReturned() {
        double diagnosticPeriod = 1.5;
        int medicalRecordId = 1;
        int symptomId = 1;
        MedicalRecordSymptomParams medicalRecordSymptomParams = new MedicalRecordSymptomParams();

        medicalRecordSymptomParams.setDiagnosticPeriod(diagnosticPeriod);
        medicalRecordSymptomParams.setMedicalRecordId(medicalRecordId);
        medicalRecordSymptomParams.setSymptomId(symptomId);

        ResponseEntity<Object> responseEntity = medicalRecordSymptomController.create(medicalRecordSymptomParams);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        MedicalRecordSymptomDTO medicalRecordSymptom = (MedicalRecordSymptomDTO) response.getData();

        Assertions.assertNotEquals(0, medicalRecordSymptom.getId());
        Assertions.assertEquals(medicalRecordId, medicalRecordSymptom.getMedicalRecordId());
        Assertions.assertEquals(symptomId, medicalRecordSymptom.getSymptomDTO().getId());

    }

    @Test
    void whenInvalidSymptomIdForSymptomDetailCreationUIsSubmittedThenExceptionShouldBeThrown() {
        double diagnosticPeriod = 1.5;
        int medicalRecordId = 1;
        int symptomId = -1;
        MedicalRecordSymptomParams medicalRecordSymptomParams = new MedicalRecordSymptomParams();

        medicalRecordSymptomParams.setDiagnosticPeriod(diagnosticPeriod);
        medicalRecordSymptomParams.setMedicalRecordId(medicalRecordId);
        medicalRecordSymptomParams.setSymptomId(symptomId);

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordSymptomController.create(medicalRecordSymptomParams));
        Assertions.assertEquals(PokemonCenterResponse.SYMPTOM_NOT_FOUND.getValue(), exception.getResponseCode());

    }

    @Test
    void whenInvalidMedicalRecordIdForSymptomDetailCreationUIsSubmittedThenExceptionShouldBeThrown() {
        double diagnosticPeriod = 1.5;
        int medicalRecordId = -1;
        int symptomId = 1;
        MedicalRecordSymptomParams medicalRecordSymptomParams = new MedicalRecordSymptomParams();

        medicalRecordSymptomParams.setDiagnosticPeriod(diagnosticPeriod);
        medicalRecordSymptomParams.setMedicalRecordId(medicalRecordId);
        medicalRecordSymptomParams.setSymptomId(symptomId);

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordSymptomController.create(medicalRecordSymptomParams));
        Assertions.assertEquals(PokemonCenterResponse.MEDICAL_RECORD_NOT_FOUND.getValue(), exception.getResponseCode());

    }

    @Test
    void whenMultipleMedicalRecordSymptomsAreSubmitedThenAListOfRecordsShouldBeReturned(){
        double diagnosticPeriod = 1.5;
        int medicalRecordId = 1;

        List<MedicalRecordSymptomParams> medicalRecordSymptomParamsList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            MedicalRecordSymptomParams medicalRecordSymptomParams = new MedicalRecordSymptomParams();
            medicalRecordSymptomParams.setDiagnosticPeriod(diagnosticPeriod);
            medicalRecordSymptomParams.setMedicalRecordId(medicalRecordId);
            medicalRecordSymptomParams.setSymptomId(i);
            medicalRecordSymptomParamsList.add(medicalRecordSymptomParams);
        }

        ResponseEntity<Object> responseEntity = medicalRecordSymptomController.create(medicalRecordSymptomParamsList);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<MedicalRecordSymptomDTO> medicalRecordSymptomList = (List<MedicalRecordSymptomDTO>) response.getData();

        for (MedicalRecordSymptomDTO medicalRecordSymptom : medicalRecordSymptomList ) {
            Assertions.assertNotEquals(0, medicalRecordSymptom.getId());
        }
    }

    @Test
    void whenMultipleMedicalRecordSymptomsWithAtLeastOneInvalidSymptomIdAreSubmitedThenExceptionShouldBeThrown(){
        double diagnosticPeriod = 1.5;
        int medicalRecordId = 1;

        List<MedicalRecordSymptomParams> medicalRecordSymptomParamsList = new ArrayList<>();
        for (int i = -1; i <= 3; i++) {
            MedicalRecordSymptomParams medicalRecordSymptomParams = new MedicalRecordSymptomParams();
            medicalRecordSymptomParams.setDiagnosticPeriod(diagnosticPeriod);
            medicalRecordSymptomParams.setMedicalRecordId(medicalRecordId);
            medicalRecordSymptomParams.setSymptomId(i);
            medicalRecordSymptomParamsList.add(medicalRecordSymptomParams);
        }

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordSymptomController.create(medicalRecordSymptomParamsList));
        Assertions.assertEquals(PokemonCenterResponse.SYMPTOM_NOT_FOUND.getValue(), exception.getResponseCode());

    }

    @Test
    void whenValidMedicalRecordSymptomIdIsSubmittedThenARecordShouldBeReturned(){
        int medicalRecordSymptonId = 1;
        ResponseEntity<Object> responseEntity = medicalRecordSymptomController.findById(medicalRecordSymptonId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        MedicalRecordSymptomDTO medicalRecordSymptom = (MedicalRecordSymptomDTO) response.getData();

        Assertions.assertEquals(medicalRecordSymptonId, medicalRecordSymptom.getId());

    }

    @Test
    void whenInvalidMedicalRecordSymptomIdIsSubmittedThenExceptionShouldBeThrown(){
        int medicalRecordSymptonId = -1;
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordSymptomController.findById(medicalRecordSymptonId));
        Assertions.assertEquals(PokemonCenterResponse.MEDICAL_RECORD_SYMPTOM_NOT_FOUND.getValue(), exception.getResponseCode());

    }

    @Test
    void whenValidMedicalRecordIdIsSubmittedThenAListOfRecordsShouldBeReturned(){
        int medicalRecordId = 1;
        ResponseEntity<Object> responseEntity = medicalRecordSymptomController.findByMedicalRecordId(medicalRecordId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<MedicalRecordSymptom> medicalRecordSymptomList = (List<MedicalRecordSymptom>) response.getData();

        Assertions.assertInstanceOf(List.class, medicalRecordSymptomList);

    }

    @Test
    void whenInvalidMedicalRecordIdIsSubmittedThenExceptionShouldBeThrown(){
        int medicalRecordId = -1;
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordSymptomController.findByMedicalRecordId(medicalRecordId));
        Assertions.assertEquals(PokemonCenterResponse.MEDICAL_RECORD_NOT_FOUND.getValue(), exception.getResponseCode());

    }



}
