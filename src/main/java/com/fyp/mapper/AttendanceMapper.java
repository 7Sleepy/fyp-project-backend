package com.fyp.mapper;

import com.fyp.dto.AccountDTO;
import com.fyp.dto.AttendanceDTO;
import com.fyp.entity.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);

    // Convert Entity to DTO
    AttendanceDTO entityToDTO(Attendance attendance);

    // Convert Entity List to DTO List
    List<AttendanceDTO> entityToDTOList(List<Attendance> attendance);

    // Convert DTO to Entity
    Attendance dtoToEntity(AttendanceDTO attendanceDTO);

    // Convert DTO List to Entity List
    List<Attendance> dtoListToEntity(List<AttendanceDTO> attendanceDTOList);
}
