package com.fyp.controller;

import com.fyp.dto.EnrollmentDTO;
import com.fyp.entity.Enrollment;
import com.fyp.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    // Read operation (getAll)
    @GetMapping("/enrollments")
    @ResponseStatus(HttpStatus.OK)
    public List<EnrollmentDTO> readEnrollmentList() {
        return enrollmentService.readEnrollmentList();
    }

    // Read operation (byID)
    @GetMapping("/enrollments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnrollmentDTO findById(@PathVariable("id") Long id) {
        return enrollmentService.findById(id);
    }

    // Save operation
    @PostMapping("/enrollments")
    @ResponseStatus(HttpStatus.OK)
    public Enrollment createEnrollment(@Valid @RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

    // Update operation
    @PutMapping("/enrollments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnrollmentDTO updateEnrollment(@Valid @RequestBody EnrollmentDTO enrollmentDTO,
                                          @PathVariable("id") Long id) {
        return enrollmentService.updateEnrollment(enrollmentDTO, id);
    }

    // Delete operation
    @PutMapping("/enrollments/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Enrollment deleteEnrollment(@PathVariable("id") Long id) {
        return enrollmentService.deleteEnrollment(id);
    }
}
