package com.pokemon.center.service;

import com.pokemon.center.dao.PersonDao;
import com.pokemon.center.params.PersonParams;
import com.pokemon.center.persistence.Person;
import com.pokemon.center.persistence.Role;
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
        Person person = null;
        if (id > 0) {
            person = personDao.findById(id);
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
        }

        return person;
    }

    public Person createPerson(PersonParams personToCreate) {
        Person person = new Person();

        if (null != personToCreate.getEmail() && !personToCreate.getEmail().isEmpty()) {
            person.setPerName(personToCreate.getName().trim());
            person.setPerLastName(personToCreate.getLastName().trim());
            person.setPerEmail(personToCreate.getEmail().trim());
            person.setPerIdentification(personToCreate.getIdentification().trim());
            person.setPerPassword(personToCreate.getPassword().trim());

            //TODO add custom exception handler
            Role role = roleService.findById(personToCreate.getRolId());
            person.setPerRolId(role);

            person = personDao.createPerson(person);
        } else {
            return null;
        }

        return person;
    }
}
