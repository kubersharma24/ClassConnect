package com.example.MasterRoom.Model.Dtos.RequestDTOs;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
        private String role;
}
