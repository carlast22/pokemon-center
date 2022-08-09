package com.pokemon.center.controller;

import com.pokemon.center.mapping.interfaces.MedicalRecordTreatmentMapper;
import com.pokemon.center.params.MedicalRecordTreatmentParams;
import com.pokemon.center.service.MedicalRecordTreatmentService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "medicalRecordTreatment")
public class MedicalRecordTreatmentController extends ResponseManager {

    @Autowired
    MedicalRecordTreatmentService medicalRecordTreatmentService;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody MedicalRecordTreatmentParams medicalRecordTreatmentParams) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordTreatmentMapper.INSTANCE.entityToDto(medicalRecordTreatmentService.create(medicalRecordTreatmentParams)));
    }

    @PostMapping(value = "createMultiple", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody List<MedicalRecordTreatmentParams> medicalRecordTreatmentParams) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordTreatmentMapper.INSTANCE.map(medicalRecordTreatmentService.createMultiple(medicalRecordTreatmentParams)));
    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "id") int id) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordTreatmentMapper.INSTANCE.entityToDto(medicalRecordTreatmentService.findById(id)));
    }

    @GetMapping(value = "findByMedicalRecordId/{medicalRecordId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByMedicalRecordId(@PathVariable(name = "medicalRecordId") int medicalRecordId) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, MedicalRecordTreatmentMapper.INSTANCE.map(medicalRecordTreatmentService.findByMedicalRecordId(medicalRecordId)));
    }
}
