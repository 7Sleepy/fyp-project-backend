package com.fyp.service;

import com.fyp.dto.ClassDTO;
import com.fyp.entity.Class;

import java.util.List;

public interface ClassService {

    // Create operation
    Class createClass(ClassDTO classDTO);

    // Read operation (getAll)
    List<ClassDTO> readClassList();

    // Read operation (byID)
    ClassDTO findById(String id);

    // Update operation
    Class updateClass(ClassDTO classDTO, String id);

    // Delete operation (soft delete)
    Class deleteClass(ClassDTO classDTO, String id);
}
