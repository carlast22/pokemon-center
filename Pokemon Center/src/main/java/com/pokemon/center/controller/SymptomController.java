package com.pokemon.center.controller;

import com.pokemon.center.mapping.interfaces.SymptomMapper;
import com.pokemon.center.params.SymptomParams;
import com.pokemon.center.service.SymptomService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "symptom")
public class SymptomController extends ResponseManager {

    @Autowired
    SymptomService symptomService;


    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll() {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, SymptomMapper.INSTANCE.map(symptomService.findAll()));

    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "id") int id) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, SymptomMapper.INSTANCE.entityToDto(symptomService.findById(id)));
    }

    @GetMapping(value = "findByName/{symptomName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByName(@PathVariable(name = "symptomName") String symptomName) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, SymptomMapper.INSTANCE.map(symptomService.findByName(symptomName)));
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createSymptom(@RequestBody SymptomParams symptom) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, SymptomMapper.INSTANCE.entityToDto(symptomService.createSymptom(symptom)));
    }

    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateSymptom(@RequestBody SymptomParams symptom) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, SymptomMapper.INSTANCE.entityToDto(symptomService.updateSymptom(symptom)));
    }


}
