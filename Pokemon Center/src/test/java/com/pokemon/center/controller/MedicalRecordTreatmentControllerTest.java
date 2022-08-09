package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.MedicalRecordTreatmentDTO;
import com.pokemon.center.params.MedicalRecordTreatmentParams;
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
public class MedicalRecordTreatmentControllerTest {

    @Autowired
    MedicalRecordTreatmentController medicalRecordTreatmentController;


    @Test
    void whenValidMedicalRecordTreatmentParamsAreSubmittedForCreationThenARecordShouldBeReturned() {
        //mando a crear uno correcto
        MedicalRecordTreatmentParams medicalRecordTreatmentParams = new MedicalRecordTreatmentParams();
        medicalRecordTreatmentParams.setMedicalRecordId(1);
        medicalRecordTreatmentParams.setTreatmentId(1);
        medicalRecordTreatmentParams.setMedicine("Paracetamol 600mg, 1 cada 8 horas");
        ResponseEntity<Object> responseEntity = medicalRecordTreatmentController.create(medicalRecordTreatmentParams);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        MedicalRecordTreatmentDTO medicalRecordTreatmentDTO = (MedicalRecordTreatmentDTO) response.getData();

        Assertions.assertNotEquals(0, medicalRecordTreatmentDTO.getId());
        Assertions.assertNotEquals(0, medicalRecordTreatmentDTO.getId());
        Assertions.assertEquals(medicalRecordTreatmentParams.getMedicalRecordId(), medicalRecordTreatmentDTO.getMedicalRecordId());
        Assertions.assertEquals(medicalRecordTreatmentParams.getTreatmentId(), medicalRecordTreatmentDTO.getTreatment().getId());
        Assertions.assertTrue(medicalRecordTreatmentDTO.getMedicine().equals(medicalRecordTreatmentParams.getMedicine()));

    }

    @Test
    void whenMultipleValidMedicalRecordTreatmentParamsAreSubmittedForCreationThenAListOfRecordsShouldBeReturned() {
        //mando a crear multiples correctos
        List<MedicalRecordTreatmentParams> medicalRecordTreatmentParamsList = new ArrayList<>();

        MedicalRecordTreatmentParams medicalRecordTreatmentParams1 = new MedicalRecordTreatmentParams();
        medicalRecordTreatmentParams1.setMedicalRecordId(1);
        medicalRecordTreatmentParams1.setTreatmentId(1);
        medicalRecordTreatmentParams1.setMedicine("Paracetamol 600mg, 1 cada 8 horas");


        MedicalRecordTreatmentParams medicalRecordTreatmentParams2 = new MedicalRecordTreatmentParams();
        medicalRecordTreatmentParams2.setMedicalRecordId(1);
        medicalRecordTreatmentParams2.setTreatmentId(2);
        medicalRecordTreatmentParams2.setMedicine("Ibuprofeno 600mg, 1 cada 8 horas");

        medicalRecordTreatmentParamsList.add(medicalRecordTreatmentParams1);
        medicalRecordTreatmentParamsList.add(medicalRecordTreatmentParams2);

        ResponseEntity<Object> responseEntity = medicalRecordTreatmentController.create(medicalRecordTreatmentParamsList);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<MedicalRecordTreatmentDTO> medicalRecordTreatmentDTOS = (List<MedicalRecordTreatmentDTO>) response.getData();

        Assertions.assertEquals(medicalRecordTreatmentParamsList.size(), medicalRecordTreatmentDTOS.size());

    }

    @Test
    void whenInvalidMedicineTreatmentParamsIsSubmittedForCreationThenExceptionShouldBeThrowned() {
        //el parametro de medicina no se envia correcto
        MedicalRecordTreatmentParams medicalRecordTreatmentParams = new MedicalRecordTreatmentParams();
        medicalRecordTreatmentParams.setMedicalRecordId(1);
        medicalRecordTreatmentParams.setTreatmentId(1);
        medicalRecordTreatmentParams.setMedicine("   ");

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordTreatmentController.create(medicalRecordTreatmentParams));

        Assertions.assertEquals(PokemonCenterResponse.INVALID_MEDICAL_RECORD_TREATMENT_CREATION_PARAMS.getValue(), exception.getResponseCode());
    }

    @Test
    void whenInvalidMedicalRecordIdIsSubmittedForCreationThenExceptionShouldBeThrowned() {
        ////crear con registro medico invalido
        MedicalRecordTreatmentParams medicalRecordTreatmentParams = new MedicalRecordTreatmentParams();
        medicalRecordTreatmentParams.setMedicalRecordId(-1);
        medicalRecordTreatmentParams.setTreatmentId(1);
        medicalRecordTreatmentParams.setMedicine("Paracetamol 600mg, 1 cada 8 horas");
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordTreatmentController.create(medicalRecordTreatmentParams));
        Assertions.assertEquals(PokemonCenterResponse.MEDICAL_RECORD_NOT_FOUND.getValue(), exception.getResponseCode());

    }

    @Test
    void whenInvalidTreatmentIdIsSubmittedForCreationThenExceptionShouldBeThrowned() {
        //crear con tratamiento invalido
        MedicalRecordTreatmentParams medicalRecordTreatmentParams = new MedicalRecordTreatmentParams();
        medicalRecordTreatmentParams.setMedicalRecordId(1);
        medicalRecordTreatmentParams.setTreatmentId(-1);
        medicalRecordTreatmentParams.setMedicine("Paracetamol 600mg, 1 cada 8 horas");
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordTreatmentController.create(medicalRecordTreatmentParams));
        Assertions.assertEquals(PokemonCenterResponse.TREATMENT_NOT_FOUND.getValue(), exception.getResponseCode());
    }

    @Test
    void whenValidMedicalRecordTreatmentIdIsSubmittedThenARecordShouldBeReturned() {
        //lista un registro valido
        int medicalRecordTreatmentId = 1;
        ResponseEntity<Object> responseEntity = medicalRecordTreatmentController.findById(medicalRecordTreatmentId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        MedicalRecordTreatmentDTO medicalRecordTreatmentDTO = (MedicalRecordTreatmentDTO) response.getData();

        Assertions.assertEquals(medicalRecordTreatmentId, medicalRecordTreatmentDTO.getId());
    }

    @Test
    void whenInvalidMedicalRecordTreatmentIdIsSubmittedThenExceptionShouldBeThrowned() {
        //id de registro no existe
        int medicalRecordTreatmentId = -1;
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordTreatmentController.findById(medicalRecordTreatmentId));
        Assertions.assertEquals(PokemonCenterResponse.MEDICAL_RECORD_TREATMENT_NOT_FOUND.getValue(), exception.getResponseCode());
    }

    @Test
    void whenValidMedicalRecordIdIsSubmittedThenAListOfRecordsShouldBeReturned() {
        //lista por registro medico
        int medicalRecordId = 1;
        ResponseEntity<Object> responseEntity = medicalRecordTreatmentController.findByMedicalRecordId(medicalRecordId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<MedicalRecordTreatmentDTO> medicalRecordTreatmentDTOS = (List<MedicalRecordTreatmentDTO>) response.getData();

        Assertions.assertInstanceOf(List.class, medicalRecordTreatmentDTOS);

    }
}
