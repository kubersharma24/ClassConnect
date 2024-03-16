package com.example.MasterRoom.Model.Dtos.RequestDTOs.GetAllQuizReponse;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizResponse {
    private Long id;
    private String QuizName;
    private String description;
    private String status;
}
