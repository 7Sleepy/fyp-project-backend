package com.fyp.service.impl;

import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Lecturer;
import com.fyp.mapper.LecturerMapper;
import com.fyp.repository.LecturerRepository;
import com.fyp.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return lecturerMapper.entityToDTOList(lecturerRepository.findAllByIsDeletedFalseOrderByLectId());
    }

    // Read operation (by ID)
    @Override
    public LecturerDTO findById(Long id) {
        return lecturerMapper.entityToDTO(lecturerRepository.findByLectIdAndIsDeletedFalse(id));
    }

    // Create operation
    @Override
    public Lecturer createLecturer(Lecturer lecturer) {
        lecturer.setIsDeleted(false);
        return lecturerRepository.save(lecturer);
    }

    // Update operation
    @Override
    public Lecturer updateLecturer(Lecturer lecturer, Long id) {

        Lecturer lecturerToUpdate = lecturerRepository.findByLectIdAndIsDeletedFalse(id);

        lecturerToUpdate.setLect_id_number("LECT" + lecturer.getLect_id_number());
        lecturerToUpdate.setLect_firstname(lecturer.getLect_firstname());
        lecturerToUpdate.setLect_lastname(lecturer.getLect_lastname());
        lecturerToUpdate.setLect_email(lecturer.getLect_email());
        lecturerToUpdate.setLect_dob(lecturer.getLect_dob());
        lecturerToUpdate.setIsDeleted(false);

        return lecturerRepository.save(lecturerToUpdate);
    }

    // Delete operation
    @Override
    public Lecturer deleteLecturer(Long id) {
        Lecturer lecturer = lecturerRepository.findByLectIdAndIsDeletedFalse(id);
        lecturer.setIsDeleted(true);
        return lecturerRepository.save(lecturer);
    }
}
