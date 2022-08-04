package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.PersonDTO;
import com.pokemon.center.params.PersonParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void initialize() {
        PersonParams userParams = new PersonParams();
        validIdentification = generateRandomIdentification();

        userParams.setName("Juan");
        userParams.setLastName("Perez");
        userParams.setEmail("jp@tw.com");
        userParams.setIdentification(validIdentification);
        userParams.setPassword("p.123456");
        userParams.setRolId(1);

        PersonDTO personDTO = personController.createUser(userParams);
        validPersonId = personDTO.getId();
        validName = userParams.getName();
        validLastName = userParams.getLastName();
        validEmail = userParams.getEmail();
        validRolId= userParams.getRolId();
    }

    @Test
    void whenValidPersonIdIsSubmittedThenThePersonShouldBeReturned(){
        int id = this.validPersonId;
        PersonDTO person = personController.findById(id);
        Assertions.assertEquals(this.validName, person.getName());
        Assertions.assertEquals(this.validPersonId, person.getId());
        Assertions.assertEquals(this.validIdentification, person.getIdentification());

    }

    @Test
    void whenInvalidPersonIdIsSubmittedThenThePersonShouldBeEmpty(){
        int id = -1;
        PersonDTO person = personController.findById(id);
        Assertions.assertTrue(person.getName().isEmpty());
    }

    @Test
    void whenExistentNameIsSubmittedForSearchThenAPersonListShouldBeReturned(){
        String name = this.validName;
        List<PersonDTO> personDTOList = personController.findByName(name);
        Assertions.assertTrue(!personDTOList.isEmpty());
        System.out.println(personDTOList);
    }

    @Test
    void whenUnexistentNameIsSubmittedForSearchThenAEmptyListShouldBeReturned(){
        String name = "jhon";
        List<PersonDTO> personDTOList = personController.findByName(name);
        Assertions.assertTrue(personDTOList.isEmpty());
        System.out.println(personDTOList);
    }

    @Test
    void whenExistentIdentificationIsSubmittedForSearchThenAPersonShouldBeReturned(){
        String identification = this.validIdentification;

        PersonDTO personDTO = personController.findByIdentification(identification);

        Assertions.assertEquals(identification, personDTO.getIdentification());
    }

    @Test
    void whenUnexistentIdentificationIsSubmittedForSearchThenAEmptyPersonShouldBeReturned(){
        String identification = "9876543210";

        PersonDTO personDTO = personController.findByIdentification(identification);

        Assertions.assertTrue(personDTO.getIdentification().isEmpty());
    }

    @Test
    void whenCreateUserIsCalledTheUserShouldBeCreated() {
        PersonParams userParams = new PersonParams();

        userParams.setName("Juan");
        userParams.setLastName("Perez");
        userParams.setEmail("jg@tw.com");
        userParams.setIdentification(generateRandomIdentification());
        userParams.setPassword("p.123456");
        userParams.setRolId(1);

        PersonDTO personDTO = personController.createUser(userParams);

        Assertions.assertEquals(userParams.getName(), personDTO.getName());
        Assertions.assertEquals(userParams.getLastName(), personDTO.getLastName());
        Assertions.assertEquals(userParams.getIdentification(), personDTO.getIdentification());
        Assertions.assertEquals(userParams.getEmail(), personDTO.getEmail());
    }


    @Test
    void whenEmailIsNotProvidedOnPersonCreationThePersonShouldNotBeCreated() {
        PersonParams userParams = new PersonParams();
        userParams.setName("Juan");
        userParams.setLastName("Perez");
        userParams.setIdentification(generateRandomIdentification());
        userParams.setPassword("p.123456");
        userParams.setRolId(1);

        PersonDTO personDTO = personController.createUser(userParams);

        Assertions.assertNotEquals(userParams.getName(), personDTO.getName());
        Assertions.assertNotEquals(userParams.getLastName(), personDTO.getLastName());
        Assertions.assertNotEquals(userParams.getIdentification(), personDTO.getIdentification());
        Assertions.assertNotEquals(userParams.getEmail(), personDTO.getEmail());
    }

    @Test
    void whenValidPersonIdAndValidRoleIdAreSubmittedThenAPersonWithTheSpecifiedRoleShouldBeReturned(){
        int personId = this.validPersonId;
        int rolId =  this.validRolId;

        PersonDTO personDTO = personController.findByPersonIdAndRoleId(personId, rolId);

        Assertions.assertEquals(personId, personDTO.getId());
        Assertions.assertEquals(rolId, personDTO.getRole().getId());

    }

    @Test
    void whenValidPersonNameAndValidRoleIdAreSubmittedThenAPersonListWithTheSpecifiedRoleShouldBeReturned(){
        String name = this.validName;
        int rolId =  this.validRolId;

        List<PersonDTO> personDTOList = personController.findByPersonNameAndRoleId(name, rolId);
        for (PersonDTO personDTO : personDTOList ) {
            Assertions.assertEquals(rolId, personDTO.getRole().getId());
        }
    }

    @Test
    void whenUnexistentPersonNameAndValidRoleIdAreSubmittedThenAEmptyPersonListShouldBeReturned(){
        String name = "nombre falso 123";
        int rolId =  this.validRolId;

        List<PersonDTO> personDTOList = personController.findByPersonNameAndRoleId(name, rolId);
        Assertions.assertTrue(personDTOList.isEmpty());

    }

    @Test
    void whenValidPersonNameAndInvalidRoleIdAreSubmittedThenAEmptyPersonListShouldBeReturned(){
        String name = this.validName;
        int rolId =  -1;
        List<PersonDTO> personDTOList = personController.findByPersonNameAndRoleId(name, rolId);
        Assertions.assertTrue(personDTOList.isEmpty());
    }

    @Test
    void whenEmptyPersonNameAndValidRoleIdAreSubmittedThenAEmptyPersonListShouldBeReturned(){
        String name = "";
        int rolId =  -1;
        List<PersonDTO> personDTOList = personController.findByPersonNameAndRoleId(name, rolId);
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
