package com.fyp.response;

import com.fyp.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    AccountDTO account;
    String message;
    Boolean status;
}
