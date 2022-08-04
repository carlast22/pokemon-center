package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.PersonDTO;
import com.pokemon.center.mapping.interfaces.PersonMapper;
import com.pokemon.center.params.PersonParams;
import com.pokemon.center.service.PersonService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController extends ResponseManager {

    @Autowired
    PersonService personService;

    @GetMapping(value = "findByPersonId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "id") int id) {
        PersonDTO personDTO = PersonMapper.INSTANCE.entityToDto(personService.findById(id));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, personDTO);
    }

    @GetMapping(value = "findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByName(@PathVariable(name = "name") String name) {
        List<PersonDTO> personDTOList = PersonMapper.INSTANCE.map(personService.findByName(name));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, personDTOList);

    }

    @GetMapping(value = "findByIdentification/{identification}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByIdentification(@PathVariable(name = "identification") String identification) {
        PersonDTO personDTO = PersonMapper.INSTANCE.entityToDto(personService.findByIdentification(identification));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, personDTO);
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody PersonParams personToCreate) {
        PersonDTO personDTO = PersonMapper.INSTANCE.entityToDto(personService.createPerson(personToCreate));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, personDTO);
    }

    @GetMapping(value = "findByPersonIdAndRoleId/{id}/{rolId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByPersonIdAndRoleId(@PathVariable(name = "id") int personId, @PathVariable(name = "rolId") int rolId) {
        PersonDTO personDTO = PersonMapper.INSTANCE.entityToDto(personService.findByPersonIdAndRoleId(personId, rolId));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, personDTO);
    }

    @GetMapping(value = "findByPersonNameAndRoleId/{name}/{rolId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByPersonNameAndRoleId(String name, int rolId) {
        List<PersonDTO> personDTOList = PersonMapper.INSTANCE.map(personService.findByPersonNameAndRoleId(name, rolId));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, personDTOList);
    }
}
