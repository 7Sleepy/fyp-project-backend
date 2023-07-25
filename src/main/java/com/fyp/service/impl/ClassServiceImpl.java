package com.fyp.service.impl;

import com.fyp.dto.ClassDTO;
import com.fyp.entity.Class;
import com.fyp.entity.Enrollment;
import com.fyp.entity.Lecturer;
import com.fyp.mapper.ClassMapper;
import com.fyp.mapper.LecturerMapper;
import com.fyp.repository.ClassRepository;
import com.fyp.repository.EnrollmentRepository;
import com.fyp.repository.LecturerRepository;
import com.fyp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    ClassMapper classMapper;

    @Autowired
    LecturerMapper lecturerMapper;

    @Override
    public List<ClassDTO> searchWildcard(String searchTerm) {
        String wrappedSearchTerm = "Active".equals(searchTerm) ? searchTerm : "%" + searchTerm + "%";
        List<ClassDTO> classDTOList = classMapper.entityToDTOList(classRepository.searchFields(wrappedSearchTerm));

        for (ClassDTO classDTO : classDTOList) {
            Class classes = classRepository.findById(classDTO.getClassId()).orElse(null);
            if (classes != null) {
                List<Long> studentIds = new ArrayList<>();
                for (Enrollment enrollment : classes.getEnrollmentList()) {
                    studentIds.add(enrollment.getStudent().getStdnId());
                }
                classDTO.setEnrolledStdnId(studentIds);
            }
        }

        return classDTOList;
    }

    // Read operation (getAll)
    @Override
    public List<ClassDTO> readClassList() {

        List<ClassDTO> classDTOList = classMapper.entityToDTOList(classRepository.findAllByIsDeletedFalseOrderByClassId());

        for (ClassDTO classDTO : classDTOList) {
            Class classes = classRepository.findById(classDTO.getClassId()).orElse(null);
            if (classes != null) {
                List<Long> studentIds = new ArrayList<>();
                for (Enrollment enrollment : classes.getEnrollmentList()) {
                    studentIds.add(enrollment.getStudent().getStdnId());
                }
                classDTO.setEnrolledStdnId(studentIds);
            }
        }

        return classDTOList;
    }

    // Read operation (by ID)
    @Override
    public ClassDTO findById(Long id) {
        Class classes = classRepository.findByClassIdAndIsDeletedFalse(id);
        ClassDTO classDTO = classMapper.entityToDTO(classes);

        if (classes != null && classDTO != null) {
            List<Long> studentIds = new ArrayList<>();
            for (Enrollment enrollment : classes.getEnrollmentList()) {
                studentIds.add(enrollment.getStudent().getStdnId());
            }
            classDTO.setEnrolledStdnId(studentIds);
        }

        return classDTO;
    }

    // Create operation
    @Override
    public Class createClass(Class classes) {
        Lecturer lecturer = lecturerRepository.findByLectIdAndIsDeletedFalse(classes.getLecturer().getLectId());

        classes.setClass_name(classes.getClass_name());
        classes.setClass_status(classes.getClass_status());

        classes.setLecturer(lecturer);

        classes.setIsDeleted(false);
        return classRepository.save(classes);
    }

    // Update operation
    @Override
    public Class updateClass(Class classes, Long id) {
        Class existingClass = classRepository.findByClassIdAndIsDeletedFalse(id);

        existingClass.setClass_name(classes.getClass_name());
        existingClass.setClass_date(classes.getClass_date());
        existingClass.setClass_start_time(classes.getClass_start_time());
        existingClass.setClass_end_time(classes.getClass_end_time());
        existingClass.setClass_status(classes.getClass_status());
        existingClass.setIsDeleted(false);

        return classRepository.save(existingClass);
    }

    // Delete operation
    @Override
    public Class deleteClass(Long id) {
        Class classToDelete = classRepository.findByClassIdAndIsDeletedFalse(id);
        classToDelete.setIsDeleted(true);
        return classRepository.save(classToDelete);
    }
}
