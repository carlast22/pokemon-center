package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.TreatmentDTO;
import com.pokemon.center.params.TreatmentParams;
import com.pokemon.center.persistence.Treatment;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import com.pokemon.center.utilities.response.ResponseInformation;
import com.pokemon.center.utilities.response.ResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Locale;

@SpringBootTest
class TreatmentControllerTest {

    @Autowired
    TreatmentController treatmentController;

    @Test
    void whenValidSymptomCreationParamsAreSubmittedThenTheSymptomShouldBeCreated() {
        String treatmentName = "Tratamiento de insulina";
        String treatmentDescription = "Insulina de corta acción";

        TreatmentParams treatmentParams = new TreatmentParams();
        treatmentParams.setName(treatmentName);
        treatmentParams.setDescription(treatmentDescription);


        ResponseEntity<Object> responseEntity = treatmentController.create(treatmentParams);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        TreatmentDTO treatmentDTO = (TreatmentDTO) responseObject.getData();

        Assertions.assertEquals(treatmentName, treatmentDTO.getName());
        Assertions.assertEquals(treatmentDescription, treatmentDTO.getDescription());
        Assertions.assertNotEquals(0, treatmentDTO.getId());

    }

    @Test
    void whenInvalidSymptomCreationParamsAreSubmittedThenInvalidParamsExceptionShouldBeThrown() {
        String treatmentName = "  ";
        String treatmentDescription = "Descripcion para tratamiento invalido";

        TreatmentParams treatmentParams = new TreatmentParams();
        treatmentParams.setName(treatmentName);
        treatmentParams.setDescription(treatmentDescription);


        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> treatmentController.create(treatmentParams));
        Assertions.assertEquals(PokemonCenterResponse.INVALID_TREATMENT_CREATION_PARAMS.getValue(), exception.getResponseCode());

    }

    @Test
    void whenValidTreatmentIdIsSubmittedThenTheTreatmentShouldBeReturned() {

        int treatmentId = 1;

        ResponseEntity<Object> responseEntity = treatmentController.findById(treatmentId);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        TreatmentDTO treatmentDTO = (TreatmentDTO) responseObject.getData();

        Assertions.assertNotEquals(null, treatmentDTO);
    }

    @Test
    void whenInvalidTreatmentIdIsSubmittedThenTreatmentNotFoundExceptionShouldBeThrown() {

        int treatmentId = -1;

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> treatmentController.findById(treatmentId));
        Assertions.assertEquals(PokemonCenterResponse.TREATMENT_NOT_FOUND.getValue(), exception.getResponseCode());
    }


    @Test
    void whenValidTreatmentNameIsSubmittedThenListOfTreatmentsShouldBeReturned() {

        String treatmentName = "tratamiento";

        ResponseEntity<Object> responseEntity = treatmentController.findByName(treatmentName);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        List<TreatmentDTO> treatmentDTOList = (List<TreatmentDTO>) responseObject.getData();

        Assertions.assertTrue(!treatmentDTOList.isEmpty());
        for (TreatmentDTO treatment : treatmentDTOList) {
            Assertions.assertTrue(treatment.getName().toLowerCase().contains(treatmentName.toLowerCase()));
        }
    }

    @Test
    void whenInvalidTreatmentNameIsSubmittedThenAnEmptyListOfTreatmentsShouldBeReturned() {

        String treatmentName = "nombre de tratamiento que no existe";

        ResponseEntity<Object> responseEntity = treatmentController.findByName(treatmentName);
        ResponseObject responseObject = (ResponseObject) responseEntity.getBody();
        List<TreatmentDTO> treatmentDTOList = (List<TreatmentDTO>) responseObject.getData();

        Assertions.assertTrue(treatmentDTOList.isEmpty());

    }
}
