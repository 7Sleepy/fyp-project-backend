package com.fyp.service;

import com.fyp.dto.AdministratorDTO;
import com.fyp.entity.Administrator;

import java.util.List;

public interface AdministratorService {

    // Create operation
    Administrator createAdministrator(AdministratorDTO administratorDTO);

    // Read operation (getAll)
    List<AdministratorDTO> readAdministratorList();

    // Read operation (byID)
    AdministratorDTO findById(String id);

    // Update operation
    Administrator updateAdministrator(AdministratorDTO administratorDTO, String id);

    // Delete operation (soft delete)
    Administrator deleteAdministrator(AdministratorDTO administratorDTO, String id);
}
