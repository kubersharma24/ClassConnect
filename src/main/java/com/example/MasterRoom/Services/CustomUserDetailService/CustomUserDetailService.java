package com.example.MasterRoom.Services.CustomUserDetailService;

import com.example.MasterRoom.Model.Entitys.User;
import com.example.MasterRoom.Repositories.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepository.existsByEmail(username)){
            User user = userRepository.findByEmail(username);
            return user;
        }
        return null;
    }
}
