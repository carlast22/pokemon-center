package com.pokemon.center.controller;

import com.pokemon.center.mapping.dto.RoleDTO;
import com.pokemon.center.persistence.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleControllerTest {
    @Autowired
    RoleController roleController;
    @Test
    void whenAllRolesSearchIsSubmittedThenAListOfRolesShouldBeReturned(){
        List<RoleDTO> roleDTOList = roleController.findAll();
        Assertions.assertTrue(!roleDTOList.isEmpty());
    }

    @Test
    void whenValidRoleIdIsSubmittedThenARoleShouldBeReturned(){
        int roleID= 1;
        RoleDTO roleDTO = roleController.findById(roleID);
        Assertions.assertEquals(roleID, roleDTO.getId());
        Assertions.assertTrue(!roleDTO.getName().isEmpty());
    }

    @Test
    void whenInValidRoleIdIsSubmittedThenARoleShouldBeReturned(){
        int roleID= -1;
        RoleDTO roleDTO = roleController.findById(roleID);
        Assertions.assertNotEquals(roleID, roleDTO.getId());
        Assertions.assertEquals(null , roleDTO.getName());
    }



}
