package com.fyp.service;

import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Lecturer;

import java.util.List;

public interface LecturerService {

    // Create operation
    Lecturer createLecturer(Lecturer lecturer);

    // Read operation (getAll)
    List<LecturerDTO> readLecturerList();

    // Read operation (byID)
    LecturerDTO findById(Long id);

    // Update operation
    Lecturer updateLecturer(Lecturer lecturer, Long id);

    // Delete operation (soft delete)
    Lecturer deleteLecturer(Long id);
}
