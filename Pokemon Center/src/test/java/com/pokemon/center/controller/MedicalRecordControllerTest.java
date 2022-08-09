package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.MedicalRecordDTO;
import com.pokemon.center.params.MedicalRecordParams;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import com.pokemon.center.utilities.response.ResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class MedicalRecordControllerTest {

    @Autowired
    MedicalRecordController medicalRecordController;

    @Test
    void whenValidMedicalRecordParamsAreSubmittedThenARecordShouldBeReturned(){
        MedicalRecordParams medicalRecordParams = new MedicalRecordParams();
        medicalRecordParams.setDiagnostic("Diagnostico");
        medicalRecordParams.setObservation("Observacion");
        medicalRecordParams.setDoctorId(1);
        medicalRecordParams.setPokemonPersonId(1);

        ResponseEntity<Object> responseEntity =  medicalRecordController.create(medicalRecordParams);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        MedicalRecordDTO medicalRecordDTO = (MedicalRecordDTO) responseObject.getData();

        Assertions.assertNotEquals(0, medicalRecordDTO.getMedicalRecordId());
        Assertions.assertEquals(medicalRecordParams.getDiagnostic(), medicalRecordDTO.getDiagnostic());
        Assertions.assertEquals(medicalRecordParams.getObservation(), medicalRecordDTO.getObservation());
        Assertions.assertEquals(medicalRecordParams.getDoctorId(), medicalRecordDTO.getDoctor().getId());
    //    Assertions.assertEquals(medicalRecordParams.getPokemonPersonId(), medicalRecordDTO.getTrainerPokemon().);


    }

    @Test
    void whenInvalidMedicalRecordDoctorIdIsSubmittedThenAnExceptionShouldBeThrowned(){

        MedicalRecordParams medicalRecordParams = new MedicalRecordParams();
        medicalRecordParams.setDiagnostic("Diagnostico");
        medicalRecordParams.setObservation("Observacion");
        medicalRecordParams.setDoctorId(-1);
        medicalRecordParams.setPokemonPersonId(1);

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordController.create(medicalRecordParams));
        Assertions.assertEquals(PokemonCenterResponse.NO_RESULT_FOUND_BY_ID.getValue(), exception.getResponseCode());
    }

    @Test
    void whenInvalidMedicalRecordPokemonPersonIdIsSubmittedThenAnExceptionShouldBeThrowned(){

        MedicalRecordParams medicalRecordParams = new MedicalRecordParams();
        medicalRecordParams.setDiagnostic("Diagnostico");
        medicalRecordParams.setObservation("Observacion");
        medicalRecordParams.setDoctorId(1);
        medicalRecordParams.setPokemonPersonId(-1);

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordController.create(medicalRecordParams));
        Assertions.assertEquals(PokemonCenterResponse.NO_RESULT_FOUND_BY_ID.getValue(), exception.getResponseCode());
    }

    //update
    @Test
    void whenValidMedicalRecordParamsAreSubmittedForUpdateThenAnUpdatedRecordShouldBeReturned(){
        MedicalRecordParams medicalRecordParams = new MedicalRecordParams();
        int numero = (int)(Math.random()*100);
        medicalRecordParams.setDiagnostic("Diagnostico  "+numero);
        medicalRecordParams.setObservation("Observacion "+numero);
        medicalRecordParams.setMedicalRecordId(1);

        ResponseEntity<Object> responseEntity =  medicalRecordController.update(medicalRecordParams);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        MedicalRecordDTO medicalRecordDTO = (MedicalRecordDTO) responseObject.getData();

        Assertions.assertEquals(medicalRecordParams.getDiagnostic(), medicalRecordDTO.getDiagnostic());
        Assertions.assertEquals(medicalRecordParams.getObservation(), medicalRecordDTO.getObservation());


    }

    //update incorrect id
    @Test
    void whenInvalidMedicalRecordParamsAreSubmittedForUpdateThenExceptionShouldBeReturned(){
        MedicalRecordParams medicalRecordParams = new MedicalRecordParams();
        int numero = (int)(Math.random()*100);
        medicalRecordParams.setDiagnostic("Diagnostico  "+numero);
        medicalRecordParams.setObservation("Observacion "+numero);
        medicalRecordParams.setMedicalRecordId(-1);

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordController.update(medicalRecordParams));
        Assertions.assertEquals(PokemonCenterResponse.MEDICAL_RECORD_NOT_FOUND.getValue(), exception.getResponseCode());
    }

    @Test
    //findById
    void whenValidMedicalRecordIdIsSubmittedThenARecordShouldBeReturned(){
        int medicalRecordId=1;
        ResponseEntity<Object> responseEntity =  medicalRecordController.findById(medicalRecordId);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        MedicalRecordDTO medicalRecordDTO = (MedicalRecordDTO) responseObject.getData();

        Assertions.assertEquals(medicalRecordId, medicalRecordDTO.getMedicalRecordId());
    }


    @Test
    void whenInvalidMedicalRecordIdIsSubmittedThenAnExceptionShouldBeThrowned(){
        int medicalRecordId=-1;
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> medicalRecordController.findById(medicalRecordId));
        Assertions.assertEquals(PokemonCenterResponse.MEDICAL_RECORD_NOT_FOUND.getValue(), exception.getResponseCode());
    }

    @Test
    void whenValidDoctorIdIsSubmittedThenAListShouldBeReturned(){
        int doctorId = 1;
        ResponseEntity<Object> responseEntity =  medicalRecordController.findByDoctorId(doctorId);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        List<MedicalRecordDTO> medicalRecordDTOList = (List<MedicalRecordDTO>) responseObject.getData();

        Assertions.assertInstanceOf(List.class, medicalRecordDTOList);

    }

    @Test
    void whenValidPokemonPersonIdIsSubmittedThenAListShouldBeReturned(){
        int pokemonPersonId = 1 ;
        ResponseEntity<Object> responseEntity =  medicalRecordController.findByPokemonPersonId(pokemonPersonId);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        List<MedicalRecordDTO> medicalRecordDTOList = (List<MedicalRecordDTO>) responseObject.getData();

        Assertions.assertInstanceOf(List.class, medicalRecordDTOList);

    }

    @Test
    //close medical record
    void whenValidMedicalRecordIdIsSubmittedToCloseThenARecordShouldBeReturned(){
        int medicalRecordId=1;
        ResponseEntity<Object> responseEntity =  medicalRecordController.closeMedicalRecord(medicalRecordId);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        MedicalRecordDTO medicalRecordDTO = (MedicalRecordDTO) responseObject.getData();
        Assertions.assertNotEquals(null, medicalRecordDTO.getEndDate());

    }



}
