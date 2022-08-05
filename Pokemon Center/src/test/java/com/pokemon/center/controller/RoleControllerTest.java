package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.PersonDTO;
import com.pokemon.center.mapping.dto.RoleDTO;
import com.pokemon.center.persistence.Role;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import com.pokemon.center.utilities.response.ResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class RoleControllerTest {
    @Autowired
    RoleController roleController;
    @Test
    void whenAllRolesSearchIsSubmittedThenAListOfRolesShouldBeReturned(){
        ResponseEntity<Object> responseEntity = roleController.findAll();
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        List<RoleDTO> roleDTOList  = ( List<RoleDTO>) response.getData();
        Assertions.assertTrue(!roleDTOList.isEmpty());
    }

    @Test
    void whenValidRoleIdIsSubmittedThenARoleShouldBeReturned(){
        int roleID= 1;

        ResponseEntity<Object> responseEntity =roleController.findById(roleID);
        ResponseObject response = (ResponseObject) responseEntity.getBody();
        RoleDTO roleDTO  = ( RoleDTO) response.getData();
        Assertions.assertEquals(roleID, roleDTO.getId());
        Assertions.assertTrue(!roleDTO.getName().isEmpty());
    }

    @Test
    void whenInValidRoleIdIsSubmittedThenARoleShouldBeReturned(){
        int roleID= -1;
        PokemonCenterException exception = Assertions.assertThrows(PokemonCenterException.class , ()-> roleController.findById(roleID))  ;
        Assertions.assertEquals(PokemonCenterResponse.ROLE_NOT_FOUND.getValue(), exception.getResponseCode());
    }



}
