package com.pokemon.center.personmanagement.controller;

import com.pokemon.center.persistence.Person;
import com.pokemon.center.personmanagement.mapping.dto.PersonDTO;
import com.pokemon.center.personmanagement.mapping.interfaces.PersonMapper;
import com.pokemon.center.personmanagement.params.AuthParams;
import com.pokemon.center.personmanagement.params.PersonParams;
import com.pokemon.center.personmanagement.service.PersonService;
import com.pokemon.center.personmanagement.util.JWTUtils;
import com.pokemon.center.personmanagement.util.PokemonCenterAuthResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//anotacion que indica  la clase es un controlador y por lo tanto sus metodos devolveran objetos
@RestController
//anotacion para ruteo de peticiones con path /person/
@RequestMapping(path = "person")
public class PersonController  extends ResponseManager {


    @Autowired
    private JWTUtils jwtTokenUtil;

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    PersonService personService;

    @PostMapping(value = "authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> authenticate(@RequestBody AuthParams authParams) {
        Person person = personService.authenticate(authParams);
        PersonDTO personDTO = PersonMapper.INSTANCE.entityToDto(person);

        final String token = jwtTokenUtil.generateToken(personDTO.toString());
        return getResponseEntity(PokemonCenterAuthResponse.SUCCESSFUL_TRANSACTION, token);
    }



}
