package com.fyp.service.impl;

import com.fyp.dto.AdministratorDTO;
import com.fyp.entity.Administrator;
import com.fyp.mapper.AdministratorMapper;
import com.fyp.repository.AdministratorRepository;
import com.fyp.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    AdministratorMapper administratorMapper;

    // Read operation (getAll)
    @Override
    public List<AdministratorDTO> readAdministratorList() {
        return administratorMapper.entityToDTOList(administratorRepository.findAllByOrderByAdmId());
    }

    // Read operation (by ID)
    @Override
    public AdministratorDTO findById(String id) {
        return administratorMapper.entityToDTO(administratorRepository.findByAdmId(id));
    }

    // Create operation
    @Override
    public Administrator createAdministrator(AdministratorDTO administratorDTO)
    {
        Administrator administrator = administratorMapper.dtoToEntity(administratorDTO);
        administrator.setCreatedAt(Timestamp.from(Instant.now()));
        return administratorRepository.save(administrator);
    }

    // Update operation
    @Override
    public Administrator updateAdministrator(AdministratorDTO administratorDTO, String id)
    {
        Administrator administrator = administratorRepository.findByAdmId(id);
        administrator.setAdmName(administratorDTO.getAdmName());
        administrator.setAdmEmail(administratorDTO.getAdmEmail());
        administrator.setAdmDob(administratorDTO.getAdmDob());
        administrator.setEditedAt(Timestamp.from(Instant.now()));
        return administratorRepository.save(administrator);
    }

    // Delete operation
    @Override
    public Administrator deleteAdministrator(AdministratorDTO administratorDTO, String id)
    {
        Administrator administrator = administratorRepository.findByAdmId(id);
        administrator.setIsDeleted(true);
        administrator.setEditedAt(Timestamp.from(Instant.now()));
        return administratorRepository.save(administrator);
    }
}
