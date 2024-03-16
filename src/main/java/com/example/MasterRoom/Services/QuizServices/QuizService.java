package com.example.MasterRoom.Services.QuizServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetAllQuizReponse.QuizResponse;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuizStatus.QuizStatusRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuizStatus.QuizStatusResponse;

import java.util.List;

public interface QuizService {
    CreateQuizResponseDTO createNewQuiz(CreateQuizRequestDTO request);

    List<QuizResponse> getAllTheQuizInClass(String classRoomCode, int page, int size);

    QuizStatusResponse setQuizStatus(QuizStatusRequestDTO request);
}
