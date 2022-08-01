package com.pokemon.center.personmanagement.dao;

import com.pokemon.center.persistence.Person;
import com.pokemon.center.personmanagement.dao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Anotamos con repository para que spring registre como bean
@Repository
public class PersonDao {
    @Autowired
    PersonRepository personRepository;

    public Person findPersonById(int id){
        return  personRepository.findPersonByPerId(id);
    }

    public Person authenticate(String email, String password){
        return personRepository.findPersonByPerEmailAndPerPasswordAndPerActiveIsTrue(email,password);
    }

}
