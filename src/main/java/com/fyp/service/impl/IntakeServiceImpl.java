package com.fyp.service.impl;

import com.fyp.dto.IntakeDTO;
import com.fyp.entity.Intake;
import com.fyp.mapper.IntakeMapper;
import com.fyp.repository.IntakeRepository;
import com.fyp.service.IntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
public class IntakeServiceImpl implements IntakeService {

    @Autowired
    IntakeRepository intakeRepository;
    @Autowired
    IntakeMapper intakeMapper;

    // Read operation (getAll)
    @Override
    public List<IntakeDTO> readIntakeList() {
        return intakeMapper.entityToDTOList(intakeRepository.findAllByOrderByIntakeId());
    }

    // Read operation (by ID)
    @Override
    public IntakeDTO findById(String id) {
        return intakeMapper.entityToDTO(intakeRepository.findByIntakeId(id));
    }

    // Create operation
    @Override
    public Intake createIntake(IntakeDTO intakeDTO) {
        Intake intake = intakeMapper.dtoToEntity(intakeDTO);
        intake.setCreatedAt(Timestamp.from(Instant.now()));
        return intakeRepository.save(intake);
    }

    // Update operation
    @Override
    public Intake updateIntake(IntakeDTO intakeDTO, String id) {
        Intake intake =  intakeRepository.findByIntakeId(id);
        intake.setIntakeName(intakeDTO.getIntakeName());
        intake.setEditedAt(Timestamp.from(Instant.now()));
        return intakeRepository.save(intake);
    }

    // Delete operation
    @Override
    public Intake deleteIntake(IntakeDTO intakeDTO, String id) {
        Intake intake =  intakeRepository.findByIntakeId(id);
        intake.setIsDeleted(true);
        intake.setEditedAt(Timestamp.from(Instant.now()));
        return intakeRepository.save(intake);
    }
}
