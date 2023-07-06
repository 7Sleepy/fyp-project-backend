package com.fyp.mapper;

import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Lecturer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LecturerMapper {

    LecturerMapper INSTANCE = Mappers.getMapper(LecturerMapper.class);

    // Convert Entity to DTO
    LecturerDTO entityToDTO(Lecturer lecturer);

    // Convert Entity List to DTO List
    List<LecturerDTO> entityToDTOList(List<Lecturer> lecturer);

    // Convert DTO to Entity
    Lecturer dtoToEntity(LecturerDTO lecturerDTO);

    // Convert DTO List to Entity List
    List<Lecturer> dtoListToEntity(List<LecturerDTO> lecturerDTOList);
}
