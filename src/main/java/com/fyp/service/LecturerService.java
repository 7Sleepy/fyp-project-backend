package com.fyp.service;

import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Lecturer;

import java.util.List;

public interface LecturerService {

    // Create operation
    Lecturer createLecturer(LecturerDTO lecturerDTO);

    // Read operation (getAll)
    List<LecturerDTO> readLecturerList();

    // Read operation (byID)
    LecturerDTO findById(String id);

    // Update operation
    Lecturer updateLecturer(LecturerDTO lecturerDTO, String id);

    // Delete operation (soft delete)
    Lecturer deleteLecturer(LecturerDTO lecturerDTO, String id);
}
