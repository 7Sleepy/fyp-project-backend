package com.fyp.mapper;

import com.fyp.dto.AccountDTO;
import com.fyp.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    // Convert Entity to DTO
    AccountDTO entityToDTO(Account account);

    // Convert Entity List to DTO List
    List<AccountDTO> entityToDTOList(List<Account> account);

    // Convert DTO to Entity
    Account dtoToEntity(AccountDTO accountDTO);

    // Convert DTO List to Entity List
    List<Account> dtoListToEntity(List<AccountDTO> accountDTOList);
}
