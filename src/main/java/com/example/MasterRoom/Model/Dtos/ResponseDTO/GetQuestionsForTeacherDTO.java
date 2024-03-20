package com.example.MasterRoom.Model.Dtos.ResponseDTO;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO.QuestionRequestDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetQuestionsForTeacherDTO {
    private String status;
    List<QuestionRequestDTO> questions;
}
