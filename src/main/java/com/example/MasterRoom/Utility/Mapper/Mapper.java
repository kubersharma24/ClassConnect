package com.example.MasterRoom.Utility.Mapper;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.RegistrationDTO;
import com.example.MasterRoom.Model.Entitys.User;
import org.modelmapper.ModelMapper;

public class Mapper {
    public static final ModelMapper modelMapper = new ModelMapper();

    public static User toEntity(RegistrationDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}