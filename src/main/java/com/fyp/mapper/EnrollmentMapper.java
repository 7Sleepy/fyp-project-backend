package com.fyp.mapper;

import com.fyp.dto.EnrollmentDTO;
import com.fyp.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    // Convert Entity to DTO
    @Mapping(source = "enrollment.enrollmentId", target = "enrollmentId")
    @Mapping(source = "enrollment.attendance_status", target = "attendance_status")
    @Mapping(target = "stdnId", ignore = true)
    @Mapping(target = "classId", ignore = true)
    EnrollmentDTO entityToDTO(Enrollment enrollment);

    // Convert DTO to Entity
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "classes", ignore = true)
    Enrollment dtoToEntity(EnrollmentDTO enrollmentDTO);

    // Convert Entity List to DTO List
    List<EnrollmentDTO> entityToDTOList(List<Enrollment> enrollment);

    // Convert DTO List to Entity List
    List<Enrollment> dtoListToEntity(List<EnrollmentDTO> enrollmentDTOList);
}
