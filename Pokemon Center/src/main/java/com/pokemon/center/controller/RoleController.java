package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.RoleDTO;
import com.pokemon.center.mapping.interfaces.RoleMapper;
import com.pokemon.center.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoleDTO> findAll() {
        return RoleMapper.INSTANCE.map(roleService.findAll());
    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoleDTO findById(@PathVariable(name = "id") int roleID) {
        return RoleMapper.INSTANCE.entityToDto(roleService.findById(roleID));
    }
}
