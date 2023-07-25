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

    // Wildcard search
    @GetMapping("/classes/search")
    @ResponseStatus(HttpStatus.OK)
    public List<ClassDTO> searchTerm(@RequestParam String searchTerm) {
        return classService.searchWildcard(searchTerm);
    }

    // Read operation (getAll)
    @GetMapping("/classes")
    @ResponseStatus(HttpStatus.OK)
    public List<ClassDTO> readClassList() {
        return classService.readClassList();
    }

    // Read operation (byID)
    @GetMapping("/classes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClassDTO findById(@PathVariable("id") Long id) {
        return classService.findById(id);
    }

    // Save operation
    @PostMapping("/classes")
    @ResponseStatus(HttpStatus.OK)
    public Class createClass(@Valid @RequestBody Class classes) {
        return classService.createClass(classes);
    }

    // Update operation
    @PutMapping("/classes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Class updateClass(@Valid @RequestBody Class classes,
                             @PathVariable("id") Long id) {
        return classService.updateClass(classes, id);
    }

    // Delete operation
    @PutMapping("/classes/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Class deleteClass(@PathVariable("id") Long id) {
        return classService.deleteClass(id);
    }
}
