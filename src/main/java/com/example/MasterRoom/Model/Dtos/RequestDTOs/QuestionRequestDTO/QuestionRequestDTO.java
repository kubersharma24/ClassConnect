package com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDTO {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
}
