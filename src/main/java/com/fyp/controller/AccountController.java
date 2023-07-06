package com.fyp.controller;

import com.fyp.dto.AccountDTO;
import com.fyp.entity.Account;
import com.fyp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    AccountService accountService;

    // Read operation (getAll)
    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> readAccountList() {
        return accountService.readAccountList();
    }

    // Read operation (byID)
    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO findById(@PathVariable("id") String id) {
        return accountService.findById(id);
    }

    // Save operation
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public Account createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    // Update operation
    @PostMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@Valid @RequestBody AccountDTO accountDTO,
                                       @PathVariable("id") String id) {
        return accountService.updateAccount(accountDTO, id);
    }

    // Delete operation
    @PostMapping("/accounts/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account deleteAccount(@Valid @RequestBody AccountDTO accountDTO,
                                 @PathVariable("id") String id) {
        return accountService.deleteAccount(accountDTO, id);
    }
}
