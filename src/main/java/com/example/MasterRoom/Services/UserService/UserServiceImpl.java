package com.example.MasterRoom.Services.UserService;

import com.example.MasterRoom.Model.Dtos.AuthDTO.LoginRequestDTO;
import com.example.MasterRoom.Model.Dtos.AuthDTO.RegistrationDTO;
import com.example.MasterRoom.Model.Entitys.User;
import com.example.MasterRoom.Repositories.UserRepository.UserRepository;
import com.example.MasterRoom.Utility.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String createNewUser(RegistrationDTO registrationDTO) {
        User user = Mapper.toEntity(registrationDTO);
        if(userRepository.existsByEmail(user.getEmail())){
            return "user already exist";
        }
        else{
          user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "ok";
        }
    }

    @Override
    public boolean checkFeilds(RegistrationDTO registrationDTO) {
        if(registrationDTO.getEmail().isBlank() ||
                registrationDTO.getRole().isBlank() ||
                registrationDTO.getFirstName().isBlank() ||
                registrationDTO.getLastName().isBlank() ||
                registrationDTO.getPassword().isBlank()
        ){
            return true;
        }
        return false;
    }

    @Override
    public String isUser(LoginRequestDTO loginRequestDTO) {
        if(userRepository.existsByEmail(loginRequestDTO.getEmail())){
            User user = userRepository.findByEmail(loginRequestDTO.getEmail());
            if(user.getPassword().equals(loginRequestDTO.getPassword())){
                return user.getRole();
            }
            return "invalid password";
        }
        return "invalid userid";
    }

    @Override
    public String GetRole(String username) {
        User user = userRepository.findByEmail(username);
        return user.getRole();
    }
}
