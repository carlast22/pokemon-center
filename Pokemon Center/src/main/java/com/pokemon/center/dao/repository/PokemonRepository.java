package com.pokemon.center.dao.repository;

import com.pokemon.center.persistence.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PokemonRepository extends JpaRepository<Pokemon, Integer>, JpaSpecificationExecutor<Pokemon> {

    Pokemon findPokemonByPokId(int id);
    Pokemon findPokemonByPokName(String name);
}
