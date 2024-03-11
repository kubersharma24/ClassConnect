package com.example.MasterRoom.Services;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.LoginRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.RegistrationDTO;

public interface UserService {
    String createNewUser(RegistrationDTO registrationDTO);

    boolean checkFeilds(RegistrationDTO registrationDTO);

    String isUser(LoginRequestDTO loginRequestDTO);
}
