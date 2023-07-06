package com.fyp.repository;

import com.fyp.entity.Account;
import com.fyp.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Administrator findByAdmId(String id);
    List<Administrator> findAllByOrderByAdmId();
}
