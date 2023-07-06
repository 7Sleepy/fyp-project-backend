package com.fyp.controller;

import com.fyp.dto.AccountDTO;
import com.fyp.dto.StudentDTO;
import com.fyp.entity.Account;
import com.fyp.entity.Student;
import com.fyp.service.AccountService;
import com.fyp.service.StudentService;
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
public class StudentController {

    @Autowired
    StudentService studentService;

    // Read operation (getAll)
    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> readStudentList() {
        return studentService.readStudentList();
    }

    // Read operation (byID)
    @GetMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO findById(@PathVariable("id") String id) {
        return studentService.findById(id);
    }

    // Save operation
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    // Update operation
    @PostMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@Valid @RequestBody StudentDTO studentDTO,
                                 @PathVariable("id") String id) {
        return studentService.updateStudent(studentDTO, id);
    }

    // Delete operation
    @PostMapping("/students/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student deleteStudent(@Valid @RequestBody StudentDTO studentDTO,
                                 @PathVariable("id") String id) {
        return studentService.deleteStudent(studentDTO, id);
    }
}
