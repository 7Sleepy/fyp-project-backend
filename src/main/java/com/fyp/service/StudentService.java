package com.fyp.service;

import com.fyp.dto.StudentDTO;
import com.fyp.entity.Student;

import java.util.List;

public interface StudentService {

    // Create operation
    Student createStudent(StudentDTO studentDTO);

    // Read operation (getAll)
    List<StudentDTO> readStudentList();

    // Read operation (byID)
    StudentDTO findById(String id);

    // Update operation
    Student updateStudent(StudentDTO studentDTO, String id);

    // Delete operation (soft delete)
    Student deleteStudent(StudentDTO studentDTO, String id);
}
