package com.fyp.repository;

import com.fyp.entity.Account;
import com.fyp.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Attendance findByStdnAttendanceId(String id);
    List<Attendance> findAllByOrderByStdnAttendanceId();
}

