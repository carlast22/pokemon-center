package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.TreatmentDTO;
import com.pokemon.center.persistence.Treatment;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface TreatmentMapper {
    TreatmentMapper INSTANCE = Mappers.getMapper(TreatmentMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "treId"),
            @Mapping(target = "name", source = "treName"),
            @Mapping(target = "description", source = "treDescription"),

    })
    TreatmentDTO entityToDto(Treatment treatment);

    List<TreatmentDTO> map(List<Treatment> treatment);
}
