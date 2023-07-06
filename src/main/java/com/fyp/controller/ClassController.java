package com.fyp.controller;

import com.fyp.dto.ClassDTO;
import com.fyp.entity.Class;
import com.fyp.service.ClassService;
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
public class ClassController {

    @Autowired
    ClassService classService;

    // Read operation (getAll)
    @GetMapping("/classes")
    @ResponseStatus(HttpStatus.OK)
    public List<ClassDTO> readClassList() {
        return classService.readClassList();
    }

    // Read operation (byID)
    @GetMapping("/classes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClassDTO findById(@PathVariable("id") String id) {
        return classService.findById(id);
    }

    // Save operation
    @PostMapping("/classes")
    @ResponseStatus(HttpStatus.OK)
    public Class createClass(@Valid @RequestBody ClassDTO classDTO) {
        return classService.createClass(classDTO);
    }

    // Update operation
    @PostMapping("/classes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Class updateClass(@Valid @RequestBody ClassDTO classDTO,
                                 @PathVariable("id") String id) {
        return classService.updateClass(classDTO, id);
    }

    // Delete operation
    @PostMapping("/classes/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Class deleteClass(@Valid @RequestBody ClassDTO classDTO,
                                 @PathVariable("id") String id) {
        return classService.deleteClass(classDTO, id);
    }
}
