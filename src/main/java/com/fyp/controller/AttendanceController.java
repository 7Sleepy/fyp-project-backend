package com.fyp.controller;

import com.fyp.dto.AttendanceDTO;
import com.fyp.entity.Attendance;
import com.fyp.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    // Read operation (getAll)
    @GetMapping("/attendances")
    @ResponseStatus(HttpStatus.OK)
    public List<AttendanceDTO> readAttendanceList() {
        return attendanceService.readAttendanceList();
    }

    // Read operation (byID)
    @GetMapping("/attendances/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AttendanceDTO findById(@PathVariable("id") String id) {
        return attendanceService.findById(id);
    }

    // Save operation
    @PostMapping("/attendances")
    @ResponseStatus(HttpStatus.OK)
    public Attendance createAttendance(@Valid @RequestBody AttendanceDTO attendanceDTO) {
        return attendanceService.createAttendance(attendanceDTO);
    }

    // Update operation
    @PostMapping("/attendances/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Attendance updateAttendance(@Valid @RequestBody AttendanceDTO attendanceDTO,
                                 @PathVariable("id") String id) {
        return attendanceService.updateAttendance(attendanceDTO, id);
    }

    // Delete operation
    @PostMapping("/attendances/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Attendance deleteAttendance(@Valid @RequestBody AttendanceDTO attendanceDTO,
                                 @PathVariable("id") String id) {
        return attendanceService.deleteAttendance(attendanceDTO, id);
    }
}
