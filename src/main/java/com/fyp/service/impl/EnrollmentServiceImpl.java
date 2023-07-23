package com.fyp.service.impl;

import com.fyp.dto.EnrollmentDTO;
import com.fyp.entity.Class;
import com.fyp.entity.Enrollment;
import com.fyp.entity.Student;
import com.fyp.mapper.EnrollmentMapper;
import com.fyp.repository.ClassRepository;
import com.fyp.repository.EnrollmentRepository;
import com.fyp.repository.StudentRepository;
import com.fyp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    EnrollmentMapper enrollmentMapper;

    // Read operation (getAll)
    @Override
    public List<EnrollmentDTO> readEnrollmentList() {
        List<Enrollment> enrollments = enrollmentRepository.findAllByIsDeletedFalseOrderByEnrollmentId();

        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
            enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());
            enrollmentDTO.setAttendance_status(enrollment.getAttendance_status());

            if (enrollment.getStudent() != null) {
                enrollmentDTO.setStdnId(enrollment.getStudent().getStdnId());
            }

            if (enrollment.getClasses() != null) {
                enrollmentDTO.setClassId(enrollment.getClasses().getClassId());
            }

            enrollmentDTOList.add(enrollmentDTO);
        }

        return enrollmentDTOList;
    }

    // Read operation (by ID)
    @Override
    public EnrollmentDTO findById(Long id) {
        return enrollmentMapper.entityToDTO(enrollmentRepository.findByEnrollmentIdAndIsDeletedFalse(id));
    }

    // Create operation
    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        Student student = studentRepository.findByStdnIdAndIsDeletedFalse(enrollment.getStudent().getStdnId());
        Class classes = classRepository.findByClassIdAndIsDeletedFalse(enrollment.getClasses().getClassId());
        enrollment.setStudent(student);
        enrollment.setClasses(classes);
        enrollment.setIsDeleted(false);
        return enrollmentRepository.save(enrollment);
    }

    // Update operation
    @Override
    public EnrollmentDTO updateEnrollment(EnrollmentDTO enrollmentDTO, Long id) {
        Enrollment enrollmentToUpdate = enrollmentRepository.findByEnrollmentIdAndIsDeletedFalse(id);
        enrollmentToUpdate.setAttendance_status(enrollmentDTO.getAttendance_status());
        enrollmentToUpdate.setIsDeleted(false);
        return enrollmentMapper.entityToDTO(enrollmentRepository.save(enrollmentToUpdate));
    }

    // Delete operation
    @Override
    public Enrollment deleteEnrollment(Long id) {
        Enrollment enrollmentToDelete = enrollmentRepository.findByEnrollmentIdAndIsDeletedFalse(id);
        enrollmentToDelete.setIsDeleted(true);
        return enrollmentRepository.save(enrollmentToDelete);
    }
}
