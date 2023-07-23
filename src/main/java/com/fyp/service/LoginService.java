package com.fyp.service;

import com.fyp.dto.UserLoginDTO;
import com.fyp.response.LoginResponse;

public interface LoginService {

    LoginResponse login(UserLoginDTO loginDTO);
}
