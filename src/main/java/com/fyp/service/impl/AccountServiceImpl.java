package com.fyp.service.impl;

import com.fyp.dto.AccountDTO;
import com.fyp.entity.Account;
import com.fyp.mapper.AccountMapper;
import com.fyp.repository.AccountRepository;
import com.fyp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountMapper accountMapper;

    // Read operation (getAll)
    @Override
    public List<AccountDTO> readAccountList() {
        return accountMapper.entityToDTOList(accountRepository.findAllByOrderByAccId());
    }

    // Read operation (by ID)
    @Override
    public AccountDTO findById(String id) {
        return accountMapper.entityToDTO(accountRepository.findByAccId(id));
    }

    // Create operation
    @Override
    public Account createAccount(AccountDTO accountDTO)
    {
        Account account = accountMapper.dtoToEntity(accountDTO);
        account.setCreatedAt(Timestamp.from(Instant.now()));
        return accountRepository.save(account);
    }

    // Update operation
    @Override
    public Account updateAccount(AccountDTO accountDTO, String id)
    {
        Account account = accountRepository.findByAccId(id);
        account.setAccPassword(accountDTO.getAccPassword());
        account.setEditedAt(Timestamp.from(Instant.now()));
        return accountRepository.save(account);
    }

    // Delete operation
    @Override
    public Account deleteAccount(AccountDTO accountDTO, String id)
    {
        Account account = accountRepository.findByAccId(id);
        account.setIsDeleted(true);
        account.setEditedAt(Timestamp.from(Instant.now()));
        return accountRepository.save(account);
    }
}
