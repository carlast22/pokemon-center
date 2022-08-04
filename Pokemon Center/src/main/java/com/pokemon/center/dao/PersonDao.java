package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.PersonRepository;
import com.pokemon.center.persistence.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao {
    @Autowired
    PersonRepository personRepository;

    public Person findById(int id) {
        return personRepository.findPersonByPerId(id);
    }

    public List<Person> findByName(String name) {
        return personRepository.findAllByPerNameIgnoreCaseContains(name);
    }

    public Person findByIdentification(String identification) {
        return personRepository.findPersonByPerIdentification(identification);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findByPersonIdAndRoleId(int personId, int rolId) {
        return personRepository.findPersonByPerIdAndPerRolIdRolId(personId, rolId);
    }

    public List<Person> findByPersonNameAndRoleId(String name, int rolId) {
        return personRepository.findAllByPerNameIgnoreCaseContainsAndPerRolIdRolId(name, rolId);
    }
}
