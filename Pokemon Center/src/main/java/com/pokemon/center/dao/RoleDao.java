package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.RoleRepository;
import com.pokemon.center.persistence.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RoleDao {

    @Autowired
    RoleRepository roleRepository;

    public Role findById(int id) {
        return roleRepository.findRoleByRolId(id);
    }
}
