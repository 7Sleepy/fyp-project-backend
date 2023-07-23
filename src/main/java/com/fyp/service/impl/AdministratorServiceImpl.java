package com.fyp.service.impl;

import com.fyp.entity.Administrator;
import com.fyp.repository.AdministratorRepository;
import com.fyp.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    // Read operation (getAll)
    @Override
    public List<Administrator> readAdministratorList() {
        return administratorRepository.findAllByIsDeletedFalseOrderByAdmId();
    }

    // Read operation (by ID)
    @Override
    public Administrator findById(Long id) {
        return administratorRepository.findByAdmIdAndIsDeletedFalse(id);
    }

    // Create operation
    @Override
    public Administrator createAdministrator(Administrator administrator) {
        administrator.setIsDeleted(false);
        return administratorRepository.save(administrator);
    }

    // Update operation
    @Override
    public Administrator updateAdministrator(Administrator administrator, Long id) {
        Administrator administratorToUpdate = administratorRepository.findByAdmIdAndIsDeletedFalse(id);

        administratorToUpdate.setAdm_id_number("ADM" + administrator.getAdm_id_number());
        administratorToUpdate.setAdm_firstname(administrator.getAdm_firstname());
        administratorToUpdate.setAdm_lastname(administrator.getAdm_lastname());
        administratorToUpdate.setAdm_email(administrator.getAdm_email());
        administratorToUpdate.setAdm_dob(administrator.getAdm_dob());
        administratorToUpdate.setIsDeleted(false);
        return administratorRepository.save(administratorToUpdate);
    }

    // Delete operation
    @Override
    public Administrator deleteAdministrator(Long id) {
        Administrator administrator = administratorRepository.findByAdmIdAndIsDeletedFalse(id);
        administrator.setIsDeleted(true);
        return administratorRepository.save(administrator);
    }
}
