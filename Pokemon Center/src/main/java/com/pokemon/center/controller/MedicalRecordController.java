package com.pokemon.center.controller;

import com.pokemon.center.mapping.interfaces.MedicalRecordMapper;
import com.pokemon.center.params.MedicalRecordParams;
import com.pokemon.center.service.MedicalRecordService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "medicalRecordController")
public class MedicalRecordController extends ResponseManager {

    @Autowired
    MedicalRecordService medicalRecordService;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody MedicalRecordParams medicalRecordParams) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordMapper.INSTANCE.entityToDto(medicalRecordService.create(medicalRecordParams)));
    }

    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody MedicalRecordParams medicalRecordParams) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordMapper.INSTANCE.entityToDto(medicalRecordService.update(medicalRecordParams)));

    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "id") int medicalRecordId) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordMapper.INSTANCE.entityToDto(medicalRecordService.findById(medicalRecordId)));

    }

    @GetMapping(value = "findByDoctorId/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByDoctorId(@PathVariable(name = "doctorId") int doctorId) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordMapper.INSTANCE.map(medicalRecordService.findByDoctorId(doctorId)));

    }

    @GetMapping(value = "findByPokemonPersonId/{pokemonPersonId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByPokemonPersonId(@PathVariable(name = "pokemonPersonId") int pokemonPersonId) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordMapper.INSTANCE.map(medicalRecordService.findByPokemonPersonId(pokemonPersonId)));
    }

    @GetMapping(value = "closeMedicalRecord/{medicalRecordId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> closeMedicalRecord(@PathVariable(name = "medicalRecordId") int medicalRecordId) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordMapper.INSTANCE.entityToDto(medicalRecordService.closeMedicalRecord(medicalRecordId)));
    }
}
