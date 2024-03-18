package com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListOfQuestionRequestDTO {
    private long quizId;
    List<QuestionRequestDTO> questions;
}
