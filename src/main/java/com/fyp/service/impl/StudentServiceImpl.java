package com.fyp.service.impl;

import com.fyp.dto.EnrollmentDTO;
import com.fyp.dto.StudentDTO;
import com.fyp.entity.Enrollment;
import com.fyp.entity.Student;
import com.fyp.mapper.StudentMapper;
import com.fyp.repository.StudentRepository;
import com.fyp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Student> students = studentRepository.findAllByIsDeletedFalseOrderByStdnId();

        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = studentMapper.entityToDTO(student);

            List<EnrollmentDTO> enrollmentDTOs = new ArrayList<>();
            for (Enrollment enrollment : student.getEnrollmentList()) {
                EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
                enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());
                enrollmentDTO.setAttendance_status(enrollment.getAttendance_status());

                if (enrollment.getStudent() != null) {
                    enrollmentDTO.setStdnId(enrollment.getStudent().getStdnId());
                }

                if (enrollment.getClasses() != null) {
                    enrollmentDTO.setClassId(enrollment.getClasses().getClassId());
                }
                enrollmentDTOs.add(enrollmentDTO);
            }

            studentDTO.setEnrollmentList(enrollmentDTOs);
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    // Read operation (by ID)
    @Override
    public StudentDTO findById(Long id) {
        Student student = studentRepository.findByStdnIdAndIsDeletedFalse(id);

        if (student == null) {
            return null;
        }
        StudentDTO studentDTO = studentMapper.entityToDTO(student);

        List<EnrollmentDTO> enrollmentDTOs = new ArrayList<>();
        for (Enrollment enrollment : student.getEnrollmentList()) {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
            enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());
            enrollmentDTO.setAttendance_status(enrollment.getAttendance_status());

            if (enrollment.getStudent() != null) {
                enrollmentDTO.setStdnId(enrollment.getStudent().getStdnId());
            }

            if (enrollment.getClasses() != null) {
                enrollmentDTO.setClassId(enrollment.getClasses().getClassId());
            }
            enrollmentDTOs.add(enrollmentDTO);
        }

        studentDTO.setEnrollmentList(enrollmentDTOs);

        return studentDTO;
    }

    // Create operation
    @Override
    public Student createStudent(Student student) {
        student.setIsDeleted(false);
        return studentRepository.save(student);
    }

    // Update operation
    @Override
    public Student updateStudent(Student student, Long id) {
        Student studentToUpdate = studentRepository.findByStdnIdAndIsDeletedFalse(id);

        studentToUpdate.setStdn_id_number("STU" + student.getStdn_id_number());
        studentToUpdate.setStdn_firstname(student.getStdn_firstname());
        studentToUpdate.setStdn_lastname(student.getStdn_lastname());
        studentToUpdate.setStdn_email(student.getStdn_email());
        studentToUpdate.setStdn_dob(student.getStdn_dob());
        studentToUpdate.setIsDeleted(false);

        return studentRepository.save(studentToUpdate);
    }

    // Delete operation
    @Override
    public Student deleteStudent(Long id) {
        Student studentToDelete = studentRepository.findByStdnIdAndIsDeletedFalse(id);
        studentToDelete.setIsDeleted(true);
        return studentRepository.save(studentToDelete);
    }
}
