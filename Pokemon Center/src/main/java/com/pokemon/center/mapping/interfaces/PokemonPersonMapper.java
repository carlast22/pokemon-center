package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.PokemonPersonDTO;
import com.pokemon.center.persistence.PokemonPerson;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface PokemonPersonMapper {
    PokemonPersonMapper INSTANCE = Mappers.getMapper(PokemonPersonMapper.class);

    @Mappings({
            @Mapping(target = "personId", source = "pokPerPerId.perId"),
            @Mapping(target = "pokemonId", source = "pokPerPokId.pokId"),
            @Mapping(target = "pokemonNickname", source = "pokPerNickname"),
            @Mapping(target = "height", source = "pokPerHeight"),
            @Mapping(target = "weight", source = "pokPerWeight")
    })
    PokemonPersonDTO entityToDto(PokemonPerson pokemonPerson);

    List<PokemonPersonDTO> map(List<PokemonPerson> pokemonPerson);
}
