package com.fyp.repository;

import com.fyp.entity.Lecturer;
import com.fyp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStdnId(String id);
    List<Student> findAllByOrderByStdnId();
}

