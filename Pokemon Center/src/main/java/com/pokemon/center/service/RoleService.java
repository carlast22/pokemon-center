package com.pokemon.center.service;

import com.pokemon.center.dao.RoleDao;
import com.pokemon.center.persistence.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public Role findById(int id) {
        Role role = null;
        if (id > 0) {
            role = roleDao.findById(id);
        }
        return role;
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
