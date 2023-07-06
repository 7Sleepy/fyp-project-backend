package com.fyp.service;

import com.fyp.dto.IntakeDTO;
import com.fyp.entity.Intake;

import java.util.List;

public interface IntakeService {

    // Create operation
    Intake createIntake(IntakeDTO intakeDTO);

    // Read operation (getAll)
    List<IntakeDTO> readIntakeList();

    // Read operation (byID)
    IntakeDTO findById(String id);

    // Update operation
    Intake updateIntake(IntakeDTO intakeDTO, String id);

    // Delete operation (soft delete)
    Intake deleteIntake(IntakeDTO intakeDTO, String id);
}
