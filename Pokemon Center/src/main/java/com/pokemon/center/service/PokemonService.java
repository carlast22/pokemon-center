package com.pokemon.center.service;

import com.pokemon.center.model.PokemonModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    public PokemonModel getExternalPokemonByName(String name) {
        String uri = "https://pokeapi.co/api/v2/pokemon/" + name;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, PokemonModel.class);
    }
}
