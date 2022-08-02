package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.SymptomDTO;
import com.pokemon.center.persistence.Symptom;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface SymptomMapper {
    SymptomMapper INSTANCE = Mappers.getMapper(SymptomMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "symId"),
            @Mapping(target = "name", source = "symName"),
            @Mapping(target = "description", source = "symDescription"),

    })
    SymptomDTO entityToDto(Symptom symptom);
    List<SymptomDTO> map(List<Symptom> symptoms);
}
