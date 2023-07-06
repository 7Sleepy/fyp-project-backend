package com.fyp.service;

import com.fyp.dto.AccountDTO;
import com.fyp.entity.Account;

import java.util.List;

public interface AccountService {

    // Create operation
    Account createAccount(AccountDTO accountDTO);

    // Read operation (getAll)
    List<AccountDTO> readAccountList();

    // Read operation (byID)
    AccountDTO findById(String id);

    // Update operation
    Account updateAccount(AccountDTO accountDTO, String id);

    // Delete operation (soft delete)
    Account deleteAccount(AccountDTO accountDTO, String id);
}
