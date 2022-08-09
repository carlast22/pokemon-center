package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.PokemonDTO;
import com.pokemon.center.mapping.interfaces.PokemonMapper;
import com.pokemon.center.params.PokemonParams;
import com.pokemon.center.service.PokemonService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "pokemon")
public class PokemonController extends ResponseManager {
    @Autowired
    PokemonService pokemonService;

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll() {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, PokemonMapper.INSTANCE.map(pokemonService.findAll()));
    }

    @GetMapping(value = "findByPokemonId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "id") int id) {
        PokemonDTO pokemonDTO = PokemonMapper.INSTANCE.entityToDto(pokemonService.findById(id));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, pokemonDTO);
    }

    @GetMapping(value = "findByPokemonName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "name") String name) {
        PokemonDTO pokemonDTO = PokemonMapper.INSTANCE.entityToDto(pokemonService.findByName(name));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, pokemonDTO);
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPokemon(@RequestBody PokemonParams pokemonToCreate) {
        PokemonDTO pokemonDTO = PokemonMapper.INSTANCE.entityToDto(pokemonService.createPokemon(pokemonToCreate));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, pokemonDTO);
    }
}
