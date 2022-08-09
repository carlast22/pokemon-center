package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.PokemonPersonRepository;
import com.pokemon.center.persistence.PokemonPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PokemonPersonDao {

    @Autowired
    PokemonPersonRepository pokemonPersonRepository;

    public List<PokemonPerson> findAll () { return pokemonPersonRepository.findAll(); }

    public PokemonPerson findById (int id) {return  pokemonPersonRepository.findPokemonPersonByPokPerId(id); }

    public PokemonPerson findByPokemonNickname (String pokemonNickname) { return pokemonPersonRepository.findPokemonPersonByPokPerNickname(pokemonNickname); }

    public PokemonPerson createPokemonPerson (PokemonPerson pokemonPerson) { return pokemonPersonRepository.save(pokemonPerson); }
}
