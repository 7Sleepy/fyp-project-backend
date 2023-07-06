package com.fyp.controller;

import com.fyp.dto.AccountDTO;
import com.fyp.dto.IntakeDTO;
import com.fyp.entity.Account;
import com.fyp.entity.Intake;
import com.fyp.service.AccountService;
import com.fyp.service.IntakeService;
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
public class IntakeController {

    @Autowired
    IntakeService intakeService;

    // Read operation (getAll)
    @GetMapping("/intakes")
    @ResponseStatus(HttpStatus.OK)
    public List<IntakeDTO> readIntakeList() {
        return intakeService.readIntakeList();
    }

    // Read operation (byID)
    @GetMapping("/intakes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IntakeDTO findById(@PathVariable("id") String id) {
        return intakeService.findById(id);
    }

    // Save operation
    @PostMapping("/intakes")
    @ResponseStatus(HttpStatus.OK)
    public Intake createIntake(@Valid @RequestBody IntakeDTO intakeDTO) {
        return intakeService.createIntake(intakeDTO);
    }

    // Update operation
    @PostMapping("/intakes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Intake updateIntake(@Valid @RequestBody IntakeDTO intakeDTO,
                                 @PathVariable("id") String id) {
        return intakeService.updateIntake(intakeDTO, id);
    }

    // Delete operation
    @PostMapping("/intakes/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Intake deleteIntake(@Valid @RequestBody IntakeDTO intakeDTO,
                                 @PathVariable("id") String id) {
        return intakeService.deleteIntake(intakeDTO, id);
    }
}
