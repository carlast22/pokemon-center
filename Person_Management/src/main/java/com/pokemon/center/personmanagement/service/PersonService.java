package com.pokemon.center.personmanagement.service;

import com.pokemon.center.persistence.Person;
import com.pokemon.center.personmanagement.dao.PersonDao;
import com.pokemon.center.personmanagement.params.AuthParams;
import com.pokemon.center.personmanagement.util.PokemonCenterAuthResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonDao personDao;


    public Person authenticate(AuthParams authParams){
        //logica de validacion de parametros, intentos previos, etc
        Person person = personDao.authenticate(authParams.getEmail(), authParams.getPassword());
        if(person == null){
            throw new PokemonCenterException(PokemonCenterAuthResponse.INVALID_CREDENTIALS);
        }
        //logica para registrar el intento si fue exitoso o no, etc
        return person;
    }


}
