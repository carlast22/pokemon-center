package com.pokemon.center.personmanagement.controller;

import com.pokemon.center.personmanagement.mapping.dto.PersonDTO;
import com.pokemon.center.personmanagement.mapping.interfaces.PersonMapper;
import com.pokemon.center.personmanagement.params.AuthParams;
import com.pokemon.center.personmanagement.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//anotacion que indica  la clase es un controlador y por lo tanto sus metodos devolveran objetos
@RestController
//anotacion para ruteo de peticiones con path /person/
@RequestMapping(path = "person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    PersonService personService;

    //anotacion para peticiones de tipo GET con la ruta findById precedida por el requestMapping de la clase
    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findPersonById(@PathVariable(name = "id") int id){
        PersonDTO personDTO = PersonMapper.INSTANCE.entityToDto( personService.findPersonById(id));
        logger.info(personDTO.toString());
        return personDTO;
    }

    @PostMapping(value = "authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO authenticate(@RequestBody AuthParams authParams){
        PersonDTO personDTO = PersonMapper.INSTANCE.entityToDto(personService.authenticate(authParams));
        return personDTO;
    }



}
