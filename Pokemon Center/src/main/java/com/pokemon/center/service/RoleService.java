package com.pokemon.center.service;

import com.pokemon.center.dao.RoleDao;
import com.pokemon.center.persistence.Role;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public Role findById(int id) {
        Role role = roleDao.findById(id);
        if (null == role) {
            throw new PokemonCenterException(PokemonCenterResponse.ROLE_NOT_FOUND);
        }
        return role;
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
