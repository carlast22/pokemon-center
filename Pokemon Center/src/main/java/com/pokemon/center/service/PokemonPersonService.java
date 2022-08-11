package com.pokemon.center.service;

import com.pokemon.center.dao.PersonDao;
import com.pokemon.center.dao.PokemonDao;
import com.pokemon.center.dao.PokemonPersonDao;
import com.pokemon.center.params.PokemonPersonParams;
import com.pokemon.center.persistence.Person;
import com.pokemon.center.persistence.Pokemon;
import com.pokemon.center.persistence.PokemonPerson;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PokemonPersonService
{
    @Autowired
    PokemonPersonDao pokemonPersonDao;
    @Autowired
    PersonDao personDao;
    @Autowired
    PokemonDao pokemonDao;

    public List<PokemonPerson> findAll(){
        return pokemonPersonDao.findAll();
    }

    public PokemonPerson findById(int id){
        PokemonPerson pokemonPerson = pokemonPersonDao.findById(id);
        if (null == pokemonPerson) {
            throw new PokemonCenterException(PokemonCenterResponse.NO_RESULT_FOUND_BY_ID);
        }
        return pokemonPerson;
    }

    public List<PokemonPerson> findByPokemonNickname(String pokemonNickname){
        List<PokemonPerson> pokemonPerson = pokemonPersonDao.findByPokemonNickname(pokemonNickname);
        if (pokemonPerson.size() == 0) {
            throw new PokemonCenterException(PokemonCenterResponse.NO_RESULT_FOUND_BY_NICKNAME);
        }
        return pokemonPerson;
    }

    public PokemonPerson createPokemonPerson(PokemonPersonParams pokemonPersonParams){
        PokemonPerson pokemonPerson = new PokemonPerson();

        if(pokemonPersonParams.getPersonId() == 0 || pokemonPersonParams.getPokemonId() == 0){
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_POKEMON_PERSON_CREATION_PARAMS);
        }

        if(pokemonPersonParams.getPokemonNickname().isEmpty()){
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_POKEMON_PERSON_CREATION_PARAMS);
        }

        Pokemon pokemon = pokemonDao.findById(pokemonPersonParams.getPokemonId());
        if(pokemon == null){
            throw new PokemonCenterException(PokemonCenterResponse.POKEMON_NOT_EXISTS);
        }

        Person person = personDao.findById(pokemonPersonParams.getPersonId());
        if(person == null){
            throw new PokemonCenterException(PokemonCenterResponse.PERSON_NOT_EXISTS);
        }

        List<PokemonPerson> existingPokemonPersons = pokemonPersonDao.findByPokemonNickname(pokemonPersonParams.getPokemonNickname());

        for (PokemonPerson item:
             existingPokemonPersons) {
            if(item.getPokPerPerId().getPerId().equals(person.getPerId())
                    && item.getPokPerNickname().equals(pokemonPersonParams.getPokemonNickname())){
                throw new PokemonCenterException(PokemonCenterResponse.POKEMON_NICKNAME_ALREADY_EXISTS);
            }
        }

        pokemonPerson.setPokPerPerId(person);
        pokemonPerson.setPokPerPokId(pokemon);
        pokemonPerson.setPokPerActive(true);
        pokemonPerson.setPokPerNickname(pokemonPersonParams.getPokemonNickname());
        pokemonPerson.setPokPerCreatedAt(new Timestamp(new Date().getTime()));
        pokemonPerson.setPokPerHeight(pokemonPersonParams.getHeight());
        pokemonPerson.setPokPerWeight(pokemonPersonParams.getWeight());

        pokemonPersonDao.createPokemonPerson(pokemonPerson);

        return pokemonPerson;
    }
}
