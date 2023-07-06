package com.fyp.controller;

import com.fyp.dto.AccountDTO;
import com.fyp.dto.LecturerDTO;
import com.fyp.entity.Account;
import com.fyp.entity.Lecturer;
import com.fyp.service.AccountService;
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
    public LecturerDTO findById(@PathVariable("id") String id) {
        return lecturerService.findById(id);
    }

    // Save operation
    @PostMapping("/lecturers")
    @ResponseStatus(HttpStatus.OK)
    public Lecturer createLecturer(@Valid @RequestBody LecturerDTO lecturerDTO) {
        return lecturerService.createLecturer(lecturerDTO);
    }

    // Update operation
    @PostMapping("/lecturers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lecturer updateLecturer(@Valid @RequestBody LecturerDTO lecturerDTO,
                                 @PathVariable("id") String id) {
        return lecturerService.updateLecturer(lecturerDTO, id);
    }

    // Delete operation
    @PostMapping("/lecturers/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lecturer deleteLecturer(@Valid @RequestBody LecturerDTO lecturerDTO,
                                   @PathVariable("id") String id) {
        return lecturerService.deleteLecturer(lecturerDTO, id);
    }
}
