package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.PersonDTO;
import com.pokemon.center.mapping.interfaces.PersonMapper;
import com.pokemon.center.params.PersonParams;
import com.pokemon.center.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable(name = "id") int id) {
        return PersonMapper.INSTANCE.entityToDto(personService.findById(id));
    }

    @GetMapping(value = "findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findByName(@PathVariable(name = "name") String name) {
        return PersonMapper.INSTANCE.map(personService.findByName(name));
    }

    @GetMapping(value = "findByIdentification/{identification}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findByIdentification(@PathVariable(name = "identification") String identification) {
        return PersonMapper.INSTANCE.entityToDto(personService.findByIdentification(identification));
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO createUser(@RequestBody PersonParams personToCreate) {
        return PersonMapper.INSTANCE.entityToDto(personService.createPerson(personToCreate));
    }

}
