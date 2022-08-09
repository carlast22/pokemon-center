package com.pokemon.center.service;

import com.pokemon.center.dao.PokemonDao;
import com.pokemon.center.model.*;
import com.pokemon.center.params.PokemonParams;
import com.pokemon.center.persistence.Pokemon;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    PokemonDao pokemonDao;

    private PokemonModel getExternalPokemonByName(String name) {

        String uri = "https://pokeapi.co/api/v2/pokemon/" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "RestTemplate");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PokemonModel> response = restTemplate.exchange(uri, HttpMethod.GET, entity, PokemonModel.class);

        return response.getBody();
    }

    private PokemonSpeciesModel getExternalPokemonSpeciesByUrl(String uri) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "RestTemplate");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PokemonSpeciesModel> response = restTemplate.exchange(uri, HttpMethod.GET, entity, PokemonSpeciesModel.class);

        return response.getBody();
    }

    public List<Pokemon> findAll() {
        return pokemonDao.findAll();
    }

    public Pokemon findById(int id) {
        Pokemon pokemon = pokemonDao.findById(id);
        if (null == pokemon) {
            throw new PokemonCenterException(PokemonCenterResponse.NO_RESULT_FOUND_BY_ID);
        }
        return pokemon;
    }

    public Pokemon findByName(String name) {
        Pokemon pokemon = pokemonDao.findByName(name);
        if (null == pokemon) {
            throw new PokemonCenterException(PokemonCenterResponse.NO_RESULT_FOUND_BY_ID);
        }
        return pokemon;
    }

    public Pokemon createPokemon(PokemonParams pokemonToCreate) {
        Pokemon pokemon = new Pokemon();

        if (pokemonToCreate.getName() != null) {

            Pokemon existingPokemon = pokemonDao.findByName(pokemonToCreate.getName());

            if (existingPokemon != null) {
                throw new PokemonCenterException(PokemonCenterResponse.POKEMON_ALREADY_EXISTS);
            }

            PokemonModel pokemonModel = getExternalPokemonByName(pokemonToCreate.getName());

            if (pokemonModel != null) {

                PokemonSpeciesModel pokemonSpeciesModel = getExternalPokemonSpeciesByUrl(pokemonModel.getSpecies().getUrl());

                if (null == pokemonSpeciesModel ){
                    throw new PokemonCenterException(PokemonCenterResponse.POKEMON_SPECIES_NOT_FOUND);
                }
                pokemon.setPokApiId(pokemonModel.getId());
                pokemon.setPokName(pokemonModel.getName());
                pokemon.setPokImage(pokemonModel.getSprites().getFrontDefault());
                pokemon.setPokSpecies(pokemonModel.getSpecies().getName());
                pokemon.setPokColors(pokemonSpeciesModel.getColor().getName());
                pokemon.setPokShape(pokemonSpeciesModel.getShape().getName());
                pokemon.setPokHabitat(pokemonSpeciesModel.getHabitat().getName());

                pokemon = pokemonDao.createPokemon(pokemon);

            } else {
                throw new PokemonCenterException(PokemonCenterResponse.POKEMON_NOT_FOUND_IN_EXTERNAL_API);
            }
        } else {
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_POKEMON_CREATION_PARAMS);
        }

        return pokemon;
    }
}
