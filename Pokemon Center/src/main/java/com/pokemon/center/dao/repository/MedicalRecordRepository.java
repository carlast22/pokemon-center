package com.pokemon.center.dao.repository;

import com.pokemon.center.persistence.MedicalRecord;
import com.pokemon.center.persistence.Person;
import com.pokemon.center.persistence.PokemonPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    MedicalRecord findMedicalRecordByMedRecId(int id);

    List<MedicalRecord> findMedicalRecordsByMedRecPerId(Person person);

    List<MedicalRecord> findMedicalRecordsByMedRecPokPerId(PokemonPerson pokemonPerson);

}
