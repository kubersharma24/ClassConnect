package com.example.MasterRoom.Controllers.QuestionController;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO.ListOfQuestionRequestDTO;
import jakarta.xml.bind.annotation.XmlSchemaTypes;
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
    @PostMapping("/question")
    public ResponseEntity<?> addQuestionsIntoQuiz(@RequestBody ListOfQuestionRequestDTO request){

            return new ResponseEntity<>(request, HttpStatus.OK);
    }
}
