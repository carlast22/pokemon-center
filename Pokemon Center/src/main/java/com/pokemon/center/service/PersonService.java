package com.pokemon.center.service;

import com.pokemon.center.dao.PersonDao;
import com.pokemon.center.params.PersonParams;
import com.pokemon.center.persistence.Person;
import com.pokemon.center.persistence.Role;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    @Autowired
    RoleService roleService;

    public Person findById(int id) {
        Person person = personDao.findById(id);
        if (null == person) {
            throw new PokemonCenterException(PokemonCenterResponse.NO_RESULT_FOUND_BY_ID);
        }
        return person;
    }

    public List<Person> findByName(String name) {
        List<Person> personList = null;
        personList = personDao.findByName(name);
        return personList;
    }

    public Person findByIdentification(String identification) {
        Person person = null;
        if (!identification.trim().isEmpty()) {
            person = personDao.findByIdentification(identification);
        } else {
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_IDENTIFICATION);
        }

        return person;
    }

    public Person createPerson(PersonParams personToCreate) {
        Person person = new Person();

        if (null != personDao.findByIdentification(personToCreate.getIdentification())) {
            throw new PokemonCenterException(PokemonCenterResponse.IDENTIFICATION_ALREADY_USED);
        }

        if (null != personToCreate.getEmail() && !personToCreate.getEmail().isEmpty()) {
            person.setPerName(personToCreate.getName().trim());
            person.setPerLastName(personToCreate.getLastName().trim());
            person.setPerEmail(personToCreate.getEmail().trim());
            person.setPerIdentification(personToCreate.getIdentification().trim());
            person.setPerPassword(personToCreate.getPassword().trim());

            Role role = roleService.findById(personToCreate.getRolId());
            if (null == role) {
                throw new PokemonCenterException(PokemonCenterResponse.ROLE_NOT_FOUND);
            }
            person.setPerRolId(role);

            person = personDao.createPerson(person);
        } else {
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_PERSON_CREATION_PARAMS);
        }

        return person;
    }

    public Person findByPersonIdAndRoleId(int personId, int rolId) {
        if (null != roleService.findById(rolId)) {
            return personDao.findByPersonIdAndRoleId(personId, rolId);
        } else {
            throw new PokemonCenterException(PokemonCenterResponse.ROLE_NOT_FOUND);
        }

    }

    public List<Person> findByPersonNameAndRoleId(String name, int rolId) {
        List<Person> personList = null;
        if (!name.trim().isEmpty() && null != roleService.findById(rolId)) {
            personList = personDao.findByPersonNameAndRoleId(name, rolId);
        }
        return personList;
    }
}
