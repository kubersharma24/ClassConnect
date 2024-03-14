package com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuizResponseDTO {
    private String status;
    private long quizId;

}
