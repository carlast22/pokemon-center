package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.MedicalRecordSymptomDTO;
import com.pokemon.center.persistence.MedicalRecordSymptom;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface MedicalRecordSymptomMapper {
    MedicalRecordSymptomMapper INSTANCE = Mappers.getMapper(MedicalRecordSymptomMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "medRecSymId"),
            @Mapping(target = "active", source = "medRecSymActive"),
            @Mapping(target = "createdAt", source = "medRecSymCreatedAt"),
            @Mapping(target = "symptomPeriod", source = "medRecSymDiagnosticsPeriod"),
            @Mapping(target = "medicalRecordId", source = "medRecSymMedRecId.medRecId"),
            @Mapping(target = "symptomDTO.id", source = "medRecSymSymId.symId"),
            @Mapping(target = "symptomDTO.name", source = "medRecSymSymId.symName"),
            @Mapping(target = "symptomDTO.description", source = "medRecSymSymId.symDescription"),
    })
    MedicalRecordSymptomDTO entityToDto(MedicalRecordSymptom medicalRecordSymptom);

    List<MedicalRecordSymptomDTO> map(List<MedicalRecordSymptom> medicalRecordSymptomList);
}
