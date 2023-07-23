package com.fyp.service;

import com.fyp.dto.AccountDTO;
import com.fyp.entity.Account;

import java.util.List;

public interface AccountService {

    // Create operation
    Account createAccount(Account account);

    // Read operation (getAll)
    List<AccountDTO> readAccountList();

    // Read operation (byID)
    AccountDTO findById(Long id);

    // Update operation
    Account updateAccount(Account account, Long id);

    // Delete operation (soft delete)
    Account deleteAccount(Long id);
}
