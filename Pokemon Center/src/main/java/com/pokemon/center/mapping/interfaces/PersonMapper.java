package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.PersonDTO;
import com.pokemon.center.persistence.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "perId"),
            @Mapping(target = "name", source = "perName"),
            @Mapping(target = "lastName", source = "perLastName"),
            @Mapping(target = "identification", source = "perIdentification"),
            @Mapping(target = "email", source = "perEmail"),
            @Mapping(target = "dateOfBirth", source = "perDateOfBirth"),
            @Mapping(target = "role.name", source = "perRolId.rolName"),
            @Mapping(target = "role.description", source = "perRolId.rolDescription")
    })
    PersonDTO entityToDto(Person orden);
    List<PersonDTO> map(List<Person> ordenes);
}

