package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.PersonDTO;
import com.pokemon.center.params.PersonParams;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import com.pokemon.center.utilities.response.ResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Random;

@SpringBootTest
class PersonControllerTest {

    @Autowired
    PersonController personController;


    int validPersonId;
    String validName;
    String validLastName;
    String validEmail;
    String validIdentification;
    int validRolId;

    @BeforeEach
    void initialize() throws PokemonCenterException {
        PersonParams userParams = new PersonParams();
        validIdentification = generateRandomIdentification();

        userParams.setName("Juan");
        userParams.setLastName("Perez");
        userParams.setEmail("jp@tw.com");
        userParams.setIdentification(validIdentification);
        userParams.setPassword("p.123456");
        userParams.setRolId(1);

        ResponseObject responseObject = (ResponseObject) (personController.createUser(userParams).getBody());
        PersonDTO personDTO = (PersonDTO) responseObject.getData();
        validPersonId = personDTO.getId();
        validName = userParams.getName();
        validLastName = userParams.getLastName();
        validEmail = userParams.getEmail();
        validRolId = userParams.getRolId();
    }

    @Test
    void whenValidPersonIdIsSubmittedThenThePersonShouldBeReturned() throws PokemonCenterException {
        int id = this.validPersonId;

        ResponseEntity<Object> responseEntity = personController.findById(id);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        PersonDTO personDTO = (PersonDTO) response.getData();

        Assertions.assertEquals(this.validPersonId, personDTO.getId());
        Assertions.assertEquals(this.validIdentification, personDTO.getIdentification());

    }

    @Test
    void whenInvalidPersonIdIsSubmittedThenNoResultsFoundExceptionShouldBeReturned() {
        int id = -1;
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class , ()-> personController.findById(id))  ;
        Assertions.assertEquals(PokemonCenterResponse.NO_RESULT_FOUND_BY_ID.getValue(), exception.getResponseCode());

    }

    @Test
    void whenExistentNameIsSubmittedForSearchThenAPersonListShouldBeReturned() {
        String name = this.validName;
        ResponseEntity<Object> responseEntity = personController.findByName(name);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<PersonDTO> personDTOList = (List<PersonDTO>) response.getData();
        Assertions.assertTrue(!personDTOList.isEmpty());
        System.out.println(personDTOList);
    }

    @Test
    void whenUnexistentNameIsSubmittedForSearchThenAEmptyListShouldBeReturned() {
        String name = "jhon";
        ResponseEntity<Object> responseEntity = personController.findByName(name);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<PersonDTO> personDTOList = (List<PersonDTO>) response.getData();
        Assertions.assertTrue(personDTOList.isEmpty());
        System.out.println(personDTOList);
    }

    @Test
    void whenExistentIdentificationIsSubmittedForSearchThenAPersonShouldBeRetusrned() throws PokemonCenterException {
        String identification = this.validIdentification;

        ResponseEntity<Object> responseEntity = personController.findByIdentification(identification);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        PersonDTO personDTO = (PersonDTO) response.getData();

        Assertions.assertEquals(identification, personDTO.getIdentification());
    }

    @Test
    void whenUnexistentIdentificationIsSubmittedForSearchThenAEmptyPersonShouldBeReturned() throws PokemonCenterException {
        String identification = "9876543210";

        ResponseEntity<Object> responseEntity = personController.findByIdentification(identification);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        PersonDTO personDTO = (PersonDTO) response.getData();

        Assertions.assertTrue(personDTO.getIdentification().isEmpty());
    }

    @Test
    void whenCreateUserIsCalledTheUserShouldBeCreated() throws PokemonCenterException {
        PersonParams userParams = new PersonParams();

        userParams.setName("Juan");
        userParams.setLastName("Perez");
        userParams.setEmail("jg@tw.com");
        userParams.setIdentification(generateRandomIdentification());
        userParams.setPassword("p.123456");
        userParams.setRolId(1);

        ResponseEntity<Object> responseEntity = personController.createUser(userParams);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        PersonDTO personDTO = (PersonDTO) response.getData();
        Assertions.assertEquals(userParams.getName(), personDTO.getName());
        Assertions.assertEquals(userParams.getLastName(), personDTO.getLastName());
        Assertions.assertEquals(userParams.getIdentification(), personDTO.getIdentification());
        Assertions.assertEquals(userParams.getEmail(), personDTO.getEmail());
    }


    @Test
    void whenEmailIsNotProvidedOnPersonCreationThenInvalidParamsExceptionShouldBeReturned() throws PokemonCenterException {
        PersonParams userParams = new PersonParams();

        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, ()-> personController.createUser(userParams));

        Assertions.assertEquals(PokemonCenterResponse.INVALID_PERSON_CREATION_PARAMS.getValue(), exception.getResponseCode());


    }

    @Test
    void whenValidPersonIdAndValidRoleIdAreSubmittedThenAPersonWithTheSpecifiedRoleShouldBeReturned() throws PokemonCenterException {
        int personId = this.validPersonId;
        int rolId = this.validRolId;

        ResponseEntity<Object> responseEntity = personController.findByPersonIdAndRoleId(personId, rolId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        PersonDTO personDTO = (PersonDTO) response.getData();
        Assertions.assertEquals(personId, personDTO.getId());
        Assertions.assertEquals(rolId, personDTO.getRole().getId());

    }

    @Test
    void whenValidPersonNameAndValidRoleIdAreSubmittedThenAPersonListWithTheSpecifiedRoleShouldBeReturned() {
        String name = this.validName;
        int rolId = this.validRolId;

        ResponseEntity<Object> responseEntity = personController.findByPersonNameAndRoleId(name, rolId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<PersonDTO> personDTOList = (List<PersonDTO>) response.getData();
        for (PersonDTO personDTO : personDTOList) {
            Assertions.assertEquals(rolId, personDTO.getRole().getId());
        }
    }

    @Test
    void whenUnexistentPersonNameAndValidRoleIdAreSubmittedThenAEmptyPersonListShouldBeReturned() {
        String name = "nombre falso 123";
        int rolId = this.validRolId;

        ResponseEntity<Object> responseEntity = personController.findByPersonNameAndRoleId(name, rolId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<PersonDTO> personDTOList = (List<PersonDTO>) response.getData();
        Assertions.assertTrue(personDTOList.isEmpty());

    }

    @Test
    void whenValidPersonNameAndInvalidRoleIdAreSubmittedThenARoleNotFoundExceptionShouldBeThrown() {
        String name = this.validName;
        int rolId = -1;
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class, () -> personController.findByPersonNameAndRoleId(name, rolId));

        Assertions.assertEquals(PokemonCenterResponse.ROLE_NOT_FOUND.getValue(), exception.getResponseCode());

    }

    @Test
    void whenEmptyPersonNameAndValidRoleIdAreSubmittedThenAEmptyPersonListShouldBeReturned() {
        String name = "";
        int rolId = -1;
        ResponseEntity<Object> responseEntity = personController.findByPersonNameAndRoleId(name, rolId);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<PersonDTO> personDTOList = (List<PersonDTO>) response.getData();
        Assertions.assertTrue(personDTOList.isEmpty());
    }

    String generateRandomIdentification() {
        int length = 10;
        Random random = new Random();
        String randomString = "";
        String allowedChars = "0123456789";
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(index);
            randomString += randomChar;
        }
        return randomString;
    }
}
