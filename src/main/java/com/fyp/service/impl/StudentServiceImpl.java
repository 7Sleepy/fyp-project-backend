package com.fyp.service.impl;

import com.fyp.dto.StudentDTO;
import com.fyp.entity.Student;
import com.fyp.mapper.StudentMapper;
import com.fyp.repository.StudentRepository;
import com.fyp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    // Read operation (getAll)
    @Override
    public List<StudentDTO> readStudentList() {
        return studentMapper.entityToDTOList(studentRepository.findAllByOrderByStdnId());
    }

    // Read operation (by ID)
    @Override
    public StudentDTO findById(String id) {
        return studentMapper.entityToDTO(studentRepository.findByStdnId(id));
    }

    // Create operation
    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.dtoToEntity(studentDTO);
        student.setCreatedAt(Timestamp.from(Instant.now()));
        return studentRepository.save(student);
    }

    // Update operation
    @Override
    public Student updateStudent(StudentDTO studentDTO, String id) {
        Student student =  studentRepository.findByStdnId(id);
        student.setStdnName(studentDTO.getStdnName());
        student.setStdnEmail(studentDTO.getStdnEmail());
        student.setStdnDob(studentDTO.getStdnDob());
        student.setEditedAt(Timestamp.from(Instant.now()));
        return studentRepository.save(student);
    }

    // Delete operation
    @Override
    public Student deleteStudent(StudentDTO studentDTO, String id) {
        Student student =  studentRepository.findByStdnId(id);
        student.setIsDeleted(true);
        student.setEditedAt(Timestamp.from(Instant.now()));
        return studentRepository.save(student);
    }
}
