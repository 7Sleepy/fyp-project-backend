package com.fyp.mapper;

import com.fyp.dto.AccountDTO;
import com.fyp.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Convert Entity to DTO
    @Mapping(source = "account.lecturer", target = "lecturer")
    @Mapping(source = "account.student", target = "student")
    @Mapping(source = "account.lecturer.classList", target = "lecturer.classDTOList")
    @Mapping(source = "account.student.enrollmentList", target = "student.enrollmentList")
    AccountDTO entityToDTO(Account account);

    // Convert DTO to Entity

    @Mapping(target = "student.account", ignore = true)
    @Mapping(target = "lecturer.account", ignore = true)
    @Mapping(target = "student.enrollmentList.isDeleted", ignore = true)
    @Mapping(target = "student.enrollmentList.student", ignore = true)
    @Mapping(target = "student.enrollmentList.classes", ignore = true)
    Account dtoToEntity(AccountDTO accountDTO);

    // Convert Entity List to DTO List
    List<AccountDTO> entityToDTOList(List<Account> account);

    // Convert DTO List to Entity List
    List<Account> dtoListToEntity(List<AccountDTO> accountDTOList);
}