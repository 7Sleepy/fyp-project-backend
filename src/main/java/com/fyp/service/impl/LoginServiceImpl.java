package com.fyp.service.impl;

import com.fyp.dto.AccountDTO;
import com.fyp.dto.UserLoginDTO;
import com.fyp.entity.Account;
import com.fyp.mapper.AccountMapper;
import com.fyp.repository.AccountRepository;
import com.fyp.response.LoginResponse;
import com.fyp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public LoginResponse login(UserLoginDTO loginDTO) {

        String message = "";
        String username = loginDTO.getAccUsername();
        Account account = accountRepository.findByAccUsernameAndIsDeletedFalse(username);

        if (account != null) {
            String enteredPassword = loginDTO.getAccPassword();
            String actualPassword = account.getAccPassword();

            boolean passwordIsMatch = enteredPassword.equals(actualPassword);

            if (passwordIsMatch) {
                Optional<Account> confirmation = accountRepository.findByAccUsernameAndAccPassword(username, actualPassword);
                if (confirmation.isPresent()) {
                    AccountDTO userAccount = accountMapper.entityToDTO(accountRepository.findByAccUsernameAndIsDeletedFalse(username));
                    return new LoginResponse(userAccount, "Login Success", true);
                } else {
                    return new LoginResponse(null, "Login Failed", false);
                }
            } else {
                return new LoginResponse(null, "Password does not match", false);
            }
        } else {
            return new LoginResponse(null, "Username does not exist", false);
        }
    }
}
