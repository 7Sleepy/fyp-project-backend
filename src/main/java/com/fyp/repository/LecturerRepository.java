package com.fyp.repository;

import com.fyp.entity.Intake;
import com.fyp.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    Lecturer findByLectId(String id);
    List<Lecturer> findAllByOrderByLectId();
}

