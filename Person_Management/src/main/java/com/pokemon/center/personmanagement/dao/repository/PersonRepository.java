package com.pokemon.center.personmanagement.dao.repository;

import com.pokemon.center.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    Person findPersonByPerId(int idPerson);
    Person findPersonByPerEmailAndPerPassword(String email, String password);
}
