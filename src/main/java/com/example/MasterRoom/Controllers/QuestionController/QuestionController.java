package com.example.MasterRoom.Controllers.QuestionController;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO.ListOfQuestionRequestDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.CreateQuestionResponseDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.GetQuestionsForTeacherDTO;
import com.example.MasterRoom.Services.QuestionServices.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    public QuestionService questionService;
    @PostMapping("/question")
    public ResponseEntity<?> addQuestionsIntoQuiz(@RequestBody ListOfQuestionRequestDTO request){
        CreateQuestionResponseDTO response = questionService.addQuestionsToQuiz(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{quiz}")
    public ResponseEntity<?> getAllQuestionsOfQuizWithQUizId(@PathVariable("quiz") long quizId){
        GetQuestionsForTeacherDTO response = questionService.getAllQuestionsOfOneQuizWithQuizId(quizId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
