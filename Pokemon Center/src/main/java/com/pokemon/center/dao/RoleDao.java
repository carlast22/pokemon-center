package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.RoleRepository;
import com.pokemon.center.mapping.dto.RoleDTO;
import com.pokemon.center.persistence.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RoleDao {

    @Autowired
    RoleRepository roleRepository;

    public Role findById(int id) {
        return roleRepository.findRoleByRolId(id);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
