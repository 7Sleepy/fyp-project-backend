package com.fyp.mapper;

import com.fyp.dto.ClassDTO;
import com.fyp.entity.Class;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    // Convert Entity to DTO
    ClassDTO entityToDTO(Class classes);

    // Convert Entity List to DTO List
    List<ClassDTO> entityToDTOList(List<Class> classes);

    // Convert DTO to Entity
    Class dtoToEntity(ClassDTO classDTO);

    // Convert DTO List to Entity List
    List<Class> dtoListToEntity(List<ClassDTO> classDTOList);
}
