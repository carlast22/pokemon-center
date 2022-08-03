package com.pokemon.center.personmanagement.service;

import com.pokemon.center.persistence.Person;
import com.pokemon.center.persistence.Role;
import com.pokemon.center.personmanagement.dao.PersonDao;
import com.pokemon.center.personmanagement.params.AuthParams;
import com.pokemon.center.personmanagement.params.PersonParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    public Person findPersonById(int id){
      return personDao.findPersonById(id);
    }

    public Person authenticate(AuthParams authParams){
        //logica de validacion de parametros, intentos previos, etc
        Person person = personDao.authenticate(authParams.getEmail(), authParams.getPassword());
        //logica para registrar el intento si fue exitoso o no, etc
        return person;
    }

    public Person createPerson(PersonParams userToCreate) {
        Person person = new Person();

        if(null != userToCreate.getEmail() && !userToCreate.getEmail().isEmpty()){
            person.setPerName(userToCreate.getName().trim());
            person.setPerLastName(userToCreate.getLastName().trim());
            person.setPerEmail(userToCreate.getEmail().trim());
            person.setPerIdentification(userToCreate.getIdentification().trim());
            person.setPerPassword(userToCreate.getPassword().trim());

            Role role = new Role();
            role.setRolId(userToCreate.getRolId());
            person.setPerRolId(role);

            person = personDao.createPerson(person);
        }else {
            return null;
        }

        return person;
    }
}
