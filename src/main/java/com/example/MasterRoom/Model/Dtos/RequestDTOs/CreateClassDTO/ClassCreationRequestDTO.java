package com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateClassDTO;

import com.example.MasterRoom.Model.Entitys.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassCreationRequestDTO {
    private String handlerId;
    private String className;
    private String description;
}
