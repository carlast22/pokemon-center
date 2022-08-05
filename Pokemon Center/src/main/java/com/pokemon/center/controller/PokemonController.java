package com.pokemon.center.controller;

import com.pokemon.center.model.PokemonModel;
import com.pokemon.center.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping(value = "findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PokemonModel get(@PathVariable(name = "name") String name) {
        return pokemonService.getExternalPokemonByName(name);
    }
}
