package com.fyp.service;

import com.fyp.dto.ClassDTO;
import com.fyp.entity.Class;

import java.util.List;

public interface ClassService {

    // Wildcard Search
    List<ClassDTO> searchWildcard(String searchTerm);

    // Create operation
    Class createClass(Class classes);

    // Read operation (getAll)
    List<ClassDTO> readClassList();

    // Read operation (byID)
    ClassDTO findById(Long id);

    // Update operation
    Class updateClass(Class classes, Long id);

    // Delete operation (soft delete)
    Class deleteClass(Long id);


}
