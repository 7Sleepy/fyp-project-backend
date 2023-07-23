package com.fyp.repository;

import com.fyp.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Enrollment findByEnrollmentIdAndIsDeletedFalse(Long id);

    List<Enrollment> findAllByIsDeletedFalseOrderByEnrollmentId();
}
