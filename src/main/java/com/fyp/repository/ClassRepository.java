package com.fyp.repository;

import com.fyp.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

    Class findByClassIdAndIsDeletedFalse(Long id);

    List<Class> findAllByIsDeletedFalseOrderByClassId();
}

