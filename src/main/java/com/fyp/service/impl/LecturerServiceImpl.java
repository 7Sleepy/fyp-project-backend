package com.fyp.service.impl;

import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Lecturer;
import com.fyp.mapper.LecturerMapper;
import com.fyp.repository.LecturerRepository;
import com.fyp.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    LecturerRepository lecturerRepository;
    @Autowired
    LecturerMapper lecturerMapper;

    // Read operation (getAll)
    @Override
    public List<LecturerDTO> readLecturerList() {
        return lecturerMapper.entityToDTOList(lecturerRepository.findAllByOrderByLectId());
    }

    // Read operation (by ID)
    @Override
    public LecturerDTO findById(String id) {
        return lecturerMapper.entityToDTO(lecturerRepository.findByLectId(id));
    }

    // Create operation
    @Override
    public Lecturer createLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerMapper.dtoToEntity(lecturerDTO);
        lecturer.setCreatedAt(Timestamp.from(Instant.now()));
        return lecturerRepository.save(lecturer);
    }

    // Update operation
    @Override
    public Lecturer updateLecturer(LecturerDTO lecturerDTO, String id) {
        Lecturer lecturer =  lecturerRepository.findByLectId(id);
        lecturer.setLectName(lecturerDTO.getLectName());
        lecturer.setLectEmail(lecturerDTO.getLectEmail());
        lecturer.setLectDob(lecturerDTO.getLectDob());
        lecturer.setEditedAt(Timestamp.from(Instant.now()));
        return lecturerRepository.save(lecturer);
    }

    // Delete operation
    @Override
    public Lecturer deleteLecturer(LecturerDTO lecturerDTO, String id) {
        Lecturer lecturer =  lecturerRepository.findByLectId(id);
        lecturer.setIsDeleted(true);
        lecturer.setEditedAt(Timestamp.from(Instant.now()));
        return lecturerRepository.save(lecturer);
    }
}
