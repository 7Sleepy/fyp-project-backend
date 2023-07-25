package com.fyp.repository;

import com.fyp.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

    Class findByClassIdAndIsDeletedFalse(Long id);

    List<Class> findAllByIsDeletedFalseOrderByClassId();

    @Query("SELECT c FROM Class c WHERE " +
            "(c.class_name LIKE :searchTerm OR" +
            " c.class_status LIKE :searchTerm OR" +
            " c.class_start_time LIKE :searchTerm OR" +
            " c.class_end_time LIKE :searchTerm) AND" +
            " c.isDeleted = false")
    List<Class> searchFields(@Param("searchTerm") String searchTerm);
}

