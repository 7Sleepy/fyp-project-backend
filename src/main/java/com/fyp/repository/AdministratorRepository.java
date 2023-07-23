package com.fyp.repository;

import com.fyp.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Administrator findByAdmIdAndIsDeletedFalse(Long id);
    List<Administrator> findAllByIsDeletedFalseOrderByAdmId();
}
