package com.fyp.service;

import com.fyp.entity.Administrator;

import java.util.List;

public interface AdministratorService {

    // Create operation
    Administrator createAdministrator(Administrator administrator);

    // Read operation (getAll)
    List<Administrator> readAdministratorList();

    // Read operation (byID)
    Administrator findById(Long id);

    // Update operation
    Administrator updateAdministrator(Administrator administrator, Long id);

    // Delete operation (soft delete)
    Administrator deleteAdministrator(Long id);
}
