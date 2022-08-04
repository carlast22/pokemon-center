package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.RoleDTO;
import com.pokemon.center.persistence.Role;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)

public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "rolId"),
            @Mapping(target = "name", source = "rolName"),
            @Mapping(target = "description", source = "rolDescription"),

    })
    RoleDTO entityToDto(Role role);

    List<RoleDTO> map(List<Role> role);
}
