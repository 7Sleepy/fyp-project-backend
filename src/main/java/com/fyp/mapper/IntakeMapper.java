package com.fyp.mapper;

import com.fyp.dto.IntakeDTO;
import com.fyp.entity.Intake;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IntakeMapper {

    IntakeMapper INSTANCE = Mappers.getMapper(IntakeMapper.class);

    // Convert Entity to DTO
    IntakeDTO entityToDTO(Intake intake);

    // Convert Entity List to DTO List
    List<IntakeDTO> entityToDTOList(List<Intake> intake);

    // Convert DTO to Entity
    Intake dtoToEntity(IntakeDTO intakeDTO);

    // Convert DTO List to Entity List
    List<Intake> dtoListToEntity(List<IntakeDTO> intakeDTOList);
}
