package com.example.MasterRoom.Services.QuestionServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO.ListOfQuestionRequestDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.CreateQuestionResponseDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.QuizResponseDTO;

public interface QuestionService {
    CreateQuestionResponseDTO addQuestionsToQuiz(ListOfQuestionRequestDTO request);
}
