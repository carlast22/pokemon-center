package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.SymptomDTO;
import com.pokemon.center.mapping.interfaces.SymptomMapper;
import com.pokemon.center.params.SymptomParams;
import com.pokemon.center.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "symptom")
public class SymptomController {

    @Autowired
    SymptomService symptomService;


    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SymptomDTO> findAll() {
        return SymptomMapper.INSTANCE.map(symptomService.findAll());
    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SymptomDTO findById(@PathVariable(name = "id") int id) {
        return SymptomMapper.INSTANCE.entityToDto(symptomService.findById(id));
    }

    @GetMapping(value = "findByName/{symptomName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SymptomDTO> findByName(@PathVariable(name = "symptomName") String symptomName) {
        return SymptomMapper.INSTANCE.map(symptomService.findByName(symptomName));
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SymptomDTO createSymptom(@RequestBody SymptomParams symptom) {
        return SymptomMapper.INSTANCE.entityToDto(symptomService.createSymptom(symptom));
    }

    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public SymptomDTO updateSymptom(@RequestBody SymptomParams symptom) {
        return SymptomMapper.INSTANCE.entityToDto(symptomService.updateSymptom(symptom));
    }


}
