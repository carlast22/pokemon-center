package com.pokemon.center.mapping.interfaces;

import com.pokemon.center.mapping.dto.MedicalRecordSymptomDTO;
import com.pokemon.center.mapping.dto.MedicalRecordTreatmentDTO;
import com.pokemon.center.persistence.MedicalRecordSymptom;
import com.pokemon.center.persistence.MedicalRecordTreatment;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface MedicalRecordTreatmentMapper {
    MedicalRecordTreatmentMapper INSTANCE = Mappers.getMapper(MedicalRecordTreatmentMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "medRecTreId"),
            @Mapping(target = "active", source = "medRecTreActive"),
            @Mapping(target = "createdAt", source = "medRecTreCreatedAt"),
            @Mapping(target = "medicine", source = "medRecMedicine"),
            @Mapping(target = "medicalRecordId", source = "medRecTreMedRecId.medRecId"),
            @Mapping(target = "treatment.id", source = "medRecTreTreId.treId"),
            @Mapping(target = "treatment.name", source = "medRecTreTreId.treName"),
            @Mapping(target = "treatment.description", source = "medRecTreTreId.treDescription"),
    })


    MedicalRecordTreatmentDTO entityToDto(MedicalRecordTreatment medicalRecordSymptom);

    List<MedicalRecordTreatmentDTO> map(List<MedicalRecordTreatment> medicalRecordSymptomList);
}
