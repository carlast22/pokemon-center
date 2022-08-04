package com.pokemon.center.dao.repository;

import com.pokemon.center.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
    Person findPersonByPerId(int id);
    List<Person> findAllByPerNameIgnoreCaseContains(String personName);
    Person findPersonByPerIdentification(String identification);
}
