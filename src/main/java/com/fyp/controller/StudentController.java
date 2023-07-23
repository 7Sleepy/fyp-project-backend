package com.fyp.controller;

import com.fyp.dto.StudentDTO;
import com.fyp.entity.Student;
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
    public StudentDTO findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    // Save operation
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // Update operation
    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@Valid @RequestBody Student student,
                                 @PathVariable("id") Long id) {
        return studentService.updateStudent(student, id);
    }

    // Delete operation
    @PutMapping("/students/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }
}
