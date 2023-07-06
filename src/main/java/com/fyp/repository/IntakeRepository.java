package com.fyp.repository;

import com.fyp.entity.Class;
import com.fyp.entity.Intake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntakeRepository extends JpaRepository<Intake, Long> {

    Intake findByIntakeId(String id);
    List<Intake> findAllByOrderByIntakeId();
}
