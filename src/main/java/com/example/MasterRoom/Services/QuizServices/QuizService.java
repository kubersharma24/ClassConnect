package com.example.MasterRoom.Services.QuizServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizResponseDTO;

public interface QuizService {
    CreateQuizResponseDTO createNewQuiz(CreateQuizRequestDTO request);
}
