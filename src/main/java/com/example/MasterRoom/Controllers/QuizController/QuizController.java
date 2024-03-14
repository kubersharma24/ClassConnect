package com.example.MasterRoom.Controllers.QuizController;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizResponseDTO;
import com.example.MasterRoom.Services.QuizServices.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/classrooms/quizzes")
    public ResponseEntity<?> createNewQuiz(@RequestBody CreateQuizRequestDTO request){
        CreateQuizResponseDTO response = quizService.createNewQuiz(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
