package com.fyp.mapper;

import com.fyp.dto.AdministratorDTO;
import com.fyp.entity.Administrator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {

    AdministratorMapper INSTANCE = Mappers.getMapper(AdministratorMapper.class);

    // Convert Entity to DTO
    AdministratorDTO entityToDTO(Administrator administrator);

    // Convert Entity List to DTO List
    List<AdministratorDTO> entityToDTOList(List<Administrator> administrator);

    // Convert DTO to Entity
    Administrator dtoToEntity(AdministratorDTO administratorDTO);

    // Convert DTO List to Entity List
    List<Administrator> dtoListToEntity(List<AdministratorDTO> administratorDTOList);
}
