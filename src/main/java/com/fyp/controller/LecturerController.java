package com.fyp.controller;

import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Lecturer;
import com.fyp.service.LecturerService;
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
public class LecturerController {

    @Autowired
    LecturerService lecturerService;

    // Read operation (getAll)
    @GetMapping("/lecturers")
    @ResponseStatus(HttpStatus.OK)
    public List<LecturerDTO> readLecturerList() {
        return lecturerService.readLecturerList();
    }

    // Read operation (byID)
    @GetMapping("/lecturers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LecturerDTO findById(@PathVariable("id") Long id) {
        return lecturerService.findById(id);
    }

    // Save operation
    @PostMapping("/lecturers")
    @ResponseStatus(HttpStatus.OK)
    public Lecturer createLecturer(@Valid @RequestBody Lecturer lecturer) {
        return lecturerService.createLecturer(lecturer);
    }

    // Update operation
    @PutMapping("/lecturers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lecturer updateLecturer(@Valid @RequestBody Lecturer lecturer,
                                   @PathVariable("id") Long id) {
        return lecturerService.updateLecturer(lecturer, id);
    }

    // Delete operation
    @PutMapping("/lecturers/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lecturer deleteLecturer(@PathVariable("id") Long id) {
        return lecturerService.deleteLecturer(id);
    }
}
