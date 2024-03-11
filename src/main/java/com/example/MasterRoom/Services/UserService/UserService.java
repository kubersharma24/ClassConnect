package com.example.MasterRoom.Services.UserService;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.LoginRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.RegistrationDTO;
import com.example.MasterRoom.Model.Entitys.User;

public interface UserService {
    String createNewUser(RegistrationDTO registrationDTO);

    boolean checkFeilds(RegistrationDTO registrationDTO);

    String isUser(LoginRequestDTO loginRequestDTO);

    String GetRole(String username);
}
