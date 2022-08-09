package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.PokemonPersonDTO;
import com.pokemon.center.mapping.interfaces.PokemonPersonMapper;
import com.pokemon.center.params.PokemonPersonParams;
import com.pokemon.center.service.PokemonPersonService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "pokemonPerson")
public class PokemonPersonController extends ResponseManager {

    @Autowired
    PokemonPersonService pokemonPersonService;

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll() {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, PokemonPersonMapper.INSTANCE.map(pokemonPersonService.findAll()));
    }

    @GetMapping(value = "findByPokemonNickname/{nickname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByPokemonNickname(@PathVariable(name = "nickname") String nickname) {
        PokemonPersonDTO pokemonPersonDTO = PokemonPersonMapper.INSTANCE.entityToDto(pokemonPersonService.findByPokemonNickname(nickname));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, pokemonPersonDTO);
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPokemonPerson(@RequestBody PokemonPersonParams pokemonPersonToCreate) {
        PokemonPersonDTO pokemonPersonDTO = PokemonPersonMapper.INSTANCE.entityToDto(pokemonPersonService.createPokemonPerson(pokemonPersonToCreate));
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, pokemonPersonDTO);
    }
}
