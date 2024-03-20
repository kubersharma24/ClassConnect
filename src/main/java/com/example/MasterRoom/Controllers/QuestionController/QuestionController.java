package com.example.MasterRoom.Controllers.QuestionController;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO.ListOfQuestionRequestDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.CreateQuestionResponseDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.QuizResponseDTO;
import com.example.MasterRoom.Services.QuestionServices.QuestionService;
import jakarta.xml.bind.annotation.XmlSchemaTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
