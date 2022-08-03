package com.pokemon.center.personmanagement.controller;

import com.pokemon.center.personmanagement.mapping.dto.PersonDTO;
import com.pokemon.center.personmanagement.params.PersonParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class PersonControllerTest {

    @Autowired
    PersonController personController;

    @Test
    public void whenCreateUserIsCalledTheUserShouldBeCreated() {
        PersonParams userParams = new PersonParams();
        userParams.setName("Jose");
        userParams.setLastName("Gonzalez");
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
    public void whenEmailIsNotProvidedOnPersonCreationThePersonShouldNotBeCreated() {
        PersonParams userParams = new PersonParams();
        userParams.setName("Jose");
        userParams.setLastName("Gonzalez");
        userParams.setIdentification(generateRandomIdentification());
        userParams.setPassword("p.123456");
        userParams.setRolId(1);

        PersonDTO personDTO = personController.createUser(userParams);

        Assertions.assertEquals(null, personDTO.getName());
        Assertions.assertEquals(null, personDTO.getLastName());
        Assertions.assertEquals(null, personDTO.getIdentification());
        Assertions.assertEquals(null, personDTO.getEmail());
    }


    public String generateRandomIdentification() {
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
