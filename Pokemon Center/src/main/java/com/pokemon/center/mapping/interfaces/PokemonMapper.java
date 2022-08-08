package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.PokemonDTO;
import com.pokemon.center.persistence.Pokemon;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface PokemonMapper {

    PokemonMapper INSTANCE = Mappers.getMapper(PokemonMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "pokId"),
            @Mapping(target = "name", source = "pokName"),
            @Mapping(target = "image", source = "pokImage"),
            @Mapping(target = "species", source = "pokSpecies"),
            @Mapping(target = "color", source = "pokColors"),
            @Mapping(target = "shape", source = "pokShape"),
            @Mapping(target = "habitat", source = "pokHabitat"),
    })
    PokemonDTO entityToDto(Pokemon pokemon);

    List<PokemonDTO> map(List<Pokemon> pokemon);
}
