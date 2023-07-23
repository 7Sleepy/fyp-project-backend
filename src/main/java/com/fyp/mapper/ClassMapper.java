package com.fyp.mapper;

import com.fyp.dto.ClassDTO;
import com.fyp.entity.Class;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ClassMapper {

    // Convert Entity to DTO
    @Mapping(source = "lecturer.lectId", target = "lecturerId")
    @Mapping(target = "enrolledStdnId", ignore = true)
    ClassDTO entityToDTO(Class classes);

    // Convert DTO to Entity
    @Mapping(source = "lecturerId", target = "lecturer.lectId")
    @Mapping(target = "enrollmentList", ignore = true)
    Class dtoToEntity(ClassDTO classDTO);

    // Convert Entity List to DTO List
    List<ClassDTO> entityToDTOList(List<Class> classes);

    // Convert DTO List to Entity List
    List<Class> dtoListToEntity(List<ClassDTO> classDTOList);
}
