package com.fyp.controller;

import com.fyp.dto.AdministratorDTO;
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
    public List<AdministratorDTO> readAdministratorList() {
        return administratorService.readAdministratorList();
    }

    // Read operation (byID)
    @GetMapping("/administrators/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdministratorDTO findById(@PathVariable("id") String id) {
        return administratorService.findById(id);
    }

    // Save operation
    @PostMapping("/administrators")
    @ResponseStatus(HttpStatus.OK)
    public Administrator createAdministrator(@Valid @RequestBody AdministratorDTO administratorDTO) {
        return administratorService.createAdministrator(administratorDTO);
    }

    // Update operation
    @PostMapping("/administrators/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Administrator updateAdministrator(@Valid @RequestBody AdministratorDTO administratorDTO,
                                 @PathVariable("id") String id) {
        return administratorService.updateAdministrator(administratorDTO, id);
    }

    // Delete operation
    @PostMapping("/administrators/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Administrator deleteAdministrator(@Valid @RequestBody AdministratorDTO administratorDTO,
                                 @PathVariable("id") String id) {
        return administratorService.deleteAdministrator(administratorDTO, id);
    }
}
