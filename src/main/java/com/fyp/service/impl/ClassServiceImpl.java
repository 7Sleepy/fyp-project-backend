package com.fyp.service.impl;

import com.fyp.dto.ClassDTO;
import com.fyp.entity.Class;
import com.fyp.mapper.ClassMapper;
import com.fyp.repository.ClassRepository;
import com.fyp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;
    @Autowired
    ClassMapper classMapper;

    // Read operation (getAll)
    @Override
    public List<ClassDTO> readClassList() {
        return classMapper.entityToDTOList(classRepository.findAllByOrderByClassId());
    }

    // Read operation (by ID)
    @Override
    public ClassDTO findById(String id) {
        return classMapper.entityToDTO(classRepository.findByClassId(id));
    }

    // Create operation
    @Override
    public Class createClass(ClassDTO classDTO) {
        Class classes = classMapper.dtoToEntity(classDTO);
        classes.setCreatedAt(Timestamp.from(Instant.now()));
        return classRepository.save(classes);
    }

    // Update operation
    @Override
    public Class updateClass(ClassDTO classDTO, String id) {
        Class classes =  classRepository.findByClassId(id);
        classes.setClassName(classDTO.getClassName());
        classes.setClassStatus(classDTO.getClassStatus());
        classes.setEditedAt(Timestamp.from(Instant.now()));
        return classRepository.save(classes);
    }

    // Delete operation
    @Override
    public Class deleteClass(ClassDTO classDTO, String id) {
        Class classes =  classRepository.findByClassId(id);
        classes.setIsDeleted(true);
        classes.setEditedAt(Timestamp.from(Instant.now()));
        return classRepository.save(classes);
    }
}
