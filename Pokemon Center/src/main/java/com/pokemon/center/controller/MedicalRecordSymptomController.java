package com.pokemon.center.controller;

import com.pokemon.center.mapping.interfaces.MedicalRecordSymptomMapper;
import com.pokemon.center.params.MedicalRecordSymptomParams;
import com.pokemon.center.service.MedicalRecordSymptomService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "medicalRecordSymptom")
public class MedicalRecordSymptomController extends ResponseManager {
    @Autowired
    MedicalRecordSymptomService medicalRecordSymptomService;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody MedicalRecordSymptomParams medicalRecordSymptomParams) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordSymptomMapper.INSTANCE.entityToDto(medicalRecordSymptomService.create(medicalRecordSymptomParams)));
    }

    @PostMapping(value = "createMultiple", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody List<MedicalRecordSymptomParams> medicalRecordSymptomParamsList) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordSymptomMapper.INSTANCE.map(medicalRecordSymptomService.createList(medicalRecordSymptomParamsList)));
    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "id") int medicalRecordSymptonId) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordSymptomMapper.INSTANCE.entityToDto(medicalRecordSymptomService.findById(medicalRecordSymptonId)));
    }

    @GetMapping(value = "findByMedicalRecordId/{medicalRecordId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByMedicalRecordId(@PathVariable(name = "medicalRecordId") int medicalRecordId) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordSymptomMapper.INSTANCE.map(medicalRecordSymptomService.findByMedicalRecordId(medicalRecordId)));
    }
}
