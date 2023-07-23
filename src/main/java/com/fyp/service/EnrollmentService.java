package com.fyp.service;

import com.fyp.dto.EnrollmentDTO;
import com.fyp.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {

    // Create operation
    Enrollment createEnrollment(Enrollment enrollment);

    // Read operation (getAll)
    List<EnrollmentDTO> readEnrollmentList();

    // Read operation (byID)
    EnrollmentDTO findById(Long id);

    // Update operation
    EnrollmentDTO updateEnrollment(EnrollmentDTO enrollmentDTO, Long id);

    // Delete operation (soft delete)
    Enrollment deleteEnrollment(Long id);
}
