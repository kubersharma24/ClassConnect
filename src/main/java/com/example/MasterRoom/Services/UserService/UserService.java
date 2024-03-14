package com.example.MasterRoom.Services.UserService;

import com.example.MasterRoom.Model.Dtos.AuthDTO.LoginRequestDTO;
import com.example.MasterRoom.Model.Dtos.AuthDTO.RegistrationDTO;

public interface UserService {
    String createNewUser(RegistrationDTO registrationDTO);

    boolean checkFeilds(RegistrationDTO registrationDTO);

    String isUser(LoginRequestDTO loginRequestDTO);

    String GetRole(String username);
}
