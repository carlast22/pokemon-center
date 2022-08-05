package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.TreatmentDTO;
import com.pokemon.center.mapping.interfaces.TreatmentMapper;
import com.pokemon.center.params.TreatmentParams;
import com.pokemon.center.persistence.Treatment;
import com.pokemon.center.service.TreatmentService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "treatment")
public class TreatmentController extends ResponseManager {

    @Autowired
    TreatmentService treatmentService;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody TreatmentParams treatmentParams) {
        Treatment treatment = treatmentService.create(treatmentParams);
        TreatmentDTO treatmentDTO = TreatmentMapper.INSTANCE.entityToDto(treatment);
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, treatmentDTO);
    }

    @GetMapping(value = "findByName/{treatmentName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByName(@PathVariable(name = "treatmentName") String treatmentName) {
        List<Treatment> treatmentList = treatmentService.findByName(treatmentName);
        List<TreatmentDTO> treatmentDTOList = TreatmentMapper.INSTANCE.map(treatmentList);
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, treatmentDTOList);
    }

    @GetMapping(value = "findById/{treatmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "treatmentId") int treatmentId) {
        Treatment treatment = treatmentService.findById(treatmentId);
        TreatmentDTO treatmentDTO = TreatmentMapper.INSTANCE.entityToDto(treatment);
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, treatmentDTO);
    }
}
