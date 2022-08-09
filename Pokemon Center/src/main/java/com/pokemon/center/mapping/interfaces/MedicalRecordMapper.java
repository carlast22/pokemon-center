package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.MedicalRecordDTO;
import com.pokemon.center.persistence.MedicalRecord;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface MedicalRecordMapper {
    MedicalRecordMapper INSTANCE = Mappers.getMapper(MedicalRecordMapper.class);

    @Mappings({
            @Mapping(target = "medicalRecordId", source = "medRecId"),
            @Mapping(target = "arrivalDate", source = "medRecArrivalDate"),
            @Mapping(target = "diagnostic", source = "medRecDiagnostic"),
            @Mapping(target = "followUpDate", source = "medRecFollowUpDate"),
            @Mapping(target = "endDate", source = "medRecEndDate"),
            @Mapping(target = "observation", source = "medRecObservation"),

            @Mapping(target = "doctor.id", source = "medRecPerId.perId"),
            @Mapping(target = "doctor.name", source = "medRecPerId.perName"),
            @Mapping(target = "doctor.lastName", source = "medRecPerId.perLastName"),
            @Mapping(target = "doctor.email", source = "medRecPerId.perEmail"),

            @Mapping(target = "trainer.name", source = "medRecPokPerId.pokPerPerId.perName"),
            @Mapping(target = "trainer.lastName", source = "medRecPokPerId.pokPerPerId.perLastName"),
            @Mapping(target = "trainer.email", source = "medRecPokPerId.pokPerPerId.perEmail"),

            //TODO change to dto when ready
            @Mapping(target = "pokemon.pokName", source = "medRecPokPerId.pokPerPokId.pokName"),
            @Mapping(target = "pokemon.pokImage", source = "medRecPokPerId.pokPerPokId.pokImage"),


            //TODO change to dto when ready
            @Mapping(target = "trainerPokemon.pokPerNickname", source = "medRecPokPerId.pokPerNickname"),
            @Mapping(target = "trainerPokemon.pokPerHeight", source = "medRecPokPerId.pokPerHeight"),
            @Mapping(target = "trainerPokemon.pokPerWeight", source = "medRecPokPerId.pokPerWeight"),

    })
    MedicalRecordDTO entityToDto(MedicalRecord medicalRecord);

    List<MedicalRecordDTO> map(List<MedicalRecord> medicalRecord);
}
