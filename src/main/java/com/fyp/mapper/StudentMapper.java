package com.fyp.mapper;

import com.fyp.dto.LecturerDTO;
import com.fyp.dto.StudentDTO;
import com.fyp.entity.Lecturer;
import com.fyp.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    // Convert Entity to DTO
    StudentDTO entityToDTO(Student student);

    // Convert Entity List to DTO List
    List<StudentDTO> entityToDTOList(List<Student> student);

    // Convert DTO to Entity
    Student dtoToEntity(StudentDTO studentDTO);

    // Convert DTO List to Entity List
    List<Student> dtoListToEntity(List<StudentDTO> studentDTOList);
}
