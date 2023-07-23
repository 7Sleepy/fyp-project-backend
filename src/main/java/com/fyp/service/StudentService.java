package com.fyp.service;

import com.fyp.dto.StudentDTO;
import com.fyp.entity.Student;

import java.util.List;

public interface StudentService {

    // Create operation
    Student createStudent(Student student);

    // Read operation (getAll)
    List<StudentDTO> readStudentList();

    // Read operation (byID)
    StudentDTO findById(Long id);

    // Update operation
    Student updateStudent(Student student, Long id);

    // Delete operation (soft delete)
    Student deleteStudent(Long id);
}
