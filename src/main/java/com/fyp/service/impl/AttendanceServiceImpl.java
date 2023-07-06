package com.fyp.service.impl;

import com.fyp.dto.AttendanceDTO;
import com.fyp.entity.Attendance;
import com.fyp.mapper.AttendanceMapper;
import com.fyp.repository.AttendanceRepository;
import com.fyp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    AttendanceMapper attendanceMapper;

    // Read operation (getAll)
    @Override
    public List<AttendanceDTO> readAttendanceList() {
        return attendanceMapper.entityToDTOList(attendanceRepository.findAllByOrderByStdnAttendanceId());
    }

    // Read operation (by ID)
    @Override
    public AttendanceDTO findById(String id) {
        return attendanceMapper.entityToDTO(attendanceRepository.findByStdnAttendanceId(id));
    }

    // Create operation
    @Override
    public Attendance createAttendance(AttendanceDTO attendanceDTO)
    {
        Attendance attendance = attendanceMapper.dtoToEntity(attendanceDTO);
        attendance.setCreatedAt(Timestamp.from(Instant.now()));
        return attendanceRepository.save(attendance);
    }

    // Update operation
    @Override
    public Attendance updateAttendance(AttendanceDTO attendanceDTO, String id)
    {
        Attendance attendance = attendanceRepository.findByStdnAttendanceId(id);
        attendance.setStdnAttPercent(attendanceDTO.getStdnAttPercent());
        attendance.setEditedAt(Timestamp.from(Instant.now()));
        return attendanceRepository.save(attendance);
    }

    // Delete operation
    @Override
    public Attendance deleteAttendance(AttendanceDTO attendanceDTO, String id)
    {
        Attendance attendance = attendanceRepository.findByStdnAttendanceId(id);
        attendance.setIsDeleted(true);
        attendance.setEditedAt(Timestamp.from(Instant.now()));
        return attendanceRepository.save(attendance);
    }
}
