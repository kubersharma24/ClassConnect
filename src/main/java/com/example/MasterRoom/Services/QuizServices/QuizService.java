package com.example.MasterRoom.Services.QuizServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetAllQuizReponse.QuizResponse;

import java.util.List;

public interface QuizService {
    CreateQuizResponseDTO createNewQuiz(CreateQuizRequestDTO request);

    List<QuizResponse> getAllTheQuizInClass(String classRoomCode, int page, int size);
}
