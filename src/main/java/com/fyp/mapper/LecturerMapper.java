package com.fyp.mapper;

import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Lecturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClassMapper.class})
public interface LecturerMapper {

    // Convert Entity to DTO
    @Mapping(source = "lecturer.classList", target = "classDTOList")
    LecturerDTO entityToDTO(Lecturer lecturer);

    // Convert DTO to Entity
    @Mapping(source = "classDTOList", target = "classList")
    @Mapping(target = "account", ignore = true)
    Lecturer dtoToEntity(LecturerDTO lecturerDTO);

    // Convert Entity List to DTO List
    List<LecturerDTO> entityToDTOList(List<Lecturer> lecturer);

    // Convert DTO List to Entity List
    List<Lecturer> dtoListToEntity(List<LecturerDTO> lecturerDTOList);
}
