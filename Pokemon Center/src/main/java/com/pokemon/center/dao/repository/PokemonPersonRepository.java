package com.pokemon.center.dao.repository;

import com.pokemon.center.persistence.PokemonPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PokemonPersonRepository extends JpaRepository<PokemonPerson, Integer>, JpaSpecificationExecutor<PokemonPerson> {

    PokemonPerson findPokemonPersonByPokPerId(int id);

    PokemonPerson findPokemonPersonByPokPerNickname(String nickname);

}
