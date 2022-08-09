package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.PokemonRepository;
import com.pokemon.center.persistence.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PokemonDao {
    @Autowired
    PokemonRepository pokemonRepository;

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    public Pokemon findById(int id) {
        return pokemonRepository.findPokemonByPokId(id);
    }

    public Pokemon findByName(String name) {
        return pokemonRepository.findPokemonByPokName(name);
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
}
