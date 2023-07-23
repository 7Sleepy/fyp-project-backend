package com.fyp.controller;

import com.fyp.entity.Administrator;
import com.fyp.service.AdministratorService;
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
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    // Read operation (getAll)
    @GetMapping("/administrators")
    @ResponseStatus(HttpStatus.OK)
    public List<Administrator> readAdministratorList() {
        return administratorService.readAdministratorList();
    }

    // Read operation (byID)
    @GetMapping("/administrators/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Administrator findById(@PathVariable("id") Long id) {
        return administratorService.findById(id);
    }

    // Save operation
    @PostMapping("/administrators")
    @ResponseStatus(HttpStatus.OK)
    public Administrator createAdministrator(@Valid @RequestBody Administrator administrator) {
        return administratorService.createAdministrator(administrator);
    }

    // Update operation
    @PutMapping("/administrators/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Administrator updateAdministrator(@Valid @RequestBody Administrator administrator,
                                             @PathVariable("id") Long id) {
        return administratorService.updateAdministrator(administrator, id);
    }

    // Delete operation
    @PutMapping("/administrators/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Administrator deleteAdministrator(@PathVariable("id") Long id) {
        return administratorService.deleteAdministrator(id);
    }
}
