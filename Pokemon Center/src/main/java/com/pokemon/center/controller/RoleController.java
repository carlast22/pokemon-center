package com.pokemon.center.controller;

import com.pokemon.center.mapping.interfaces.RoleMapper;
import com.pokemon.center.service.RoleService;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.response.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "role")
public class RoleController extends ResponseManager {

    @Autowired
    RoleService roleService;

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll() {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, RoleMapper.INSTANCE.map(roleService.findAll()));
    }

    @GetMapping(value = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(name = "id") int roleID) {
        return getResponseEntity(PokemonCenterResponse.SUCCESSFUL_TRANSACTION, RoleMapper.INSTANCE.entityToDto(roleService.findById(roleID)));
    }
}
