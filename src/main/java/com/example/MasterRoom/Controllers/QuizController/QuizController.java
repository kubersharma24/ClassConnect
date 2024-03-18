package com.example.MasterRoom.Controllers.QuizController;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetAllQuizReponse.QuizResponse;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuizStatus.QuizStatusRequestDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.QuizResponseDTO;
import com.example.MasterRoom.Services.QuizServices.QuizService;
import jakarta.validation.constraints.Past;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{classroom}/quizzes")
    public ResponseEntity<?> getAllTheQuizInClassRoom(@PathVariable("classroom") String classRoomCode
            , @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "5") int size){
        List<QuizResponse> responses = quizService.getAllTheQuizInClass(classRoomCode,page,size);
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }
    @PostMapping("/classrooms/quizzes/status")
    public ResponseEntity<?> getStatusOfQuiz(@RequestBody QuizStatusRequestDTO request){
        return new ResponseEntity<>(quizService.setQuizStatus(request),HttpStatus.OK);
    }

    @DeleteMapping("/teachers/classrooms/quizzes/{quiz}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("quiz") long quiz){
        QuizResponseDTO response = quizService.deleteQuizByQuizId(quiz);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
