package com.fyp.service;

import com.fyp.dto.AttendanceDTO;
import com.fyp.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    // Create operation
    Attendance createAttendance(AttendanceDTO attendanceDTO);

    // Read operation (getAll)
    List<AttendanceDTO> readAttendanceList();

    // Read operation (byID)
    AttendanceDTO findById(String id);

    // Update operation
    Attendance updateAttendance(AttendanceDTO attendanceDTO, String id);

    // Delete operation (soft delete)
    Attendance deleteAttendance(AttendanceDTO attendanceDTO, String id);
}
