package com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuizRequestDTO {
    private String classId;
    private String quizTitle;
    private String quizDescription;
}
