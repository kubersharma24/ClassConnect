package com.example.MasterRoom.Services.QuizServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizResponseDTO;
import com.example.MasterRoom.Model.Entitys.ClassRoom;
import com.example.MasterRoom.Model.Entitys.Quiz;
import com.example.MasterRoom.Repositories.ClassRepository.ClassRepository;
import com.example.MasterRoom.Repositories.QuizRepository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImple implements QuizService{
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private ClassRepository classRepository;

    @Override
    public CreateQuizResponseDTO createNewQuiz(CreateQuizRequestDTO request) {
        try{
            ClassRoom classRoom = classRepository.findByClassCode(request.getClassId());
            Quiz quiz = Quiz.builder()
//                    .classRoom(classRoom)
                    .QuizName(request.getQuizTitle())
                    .description(request.getQuizDescription())
                    .status("on")
            .build();
//            Quiz save = quizRepository.save(quiz);
            classRoom.getQuiz().add(quiz);
            ClassRoom save = classRepository.save(classRoom);
            if(save !=null ){
                return new CreateQuizResponseDTO("ok", save.getId());
            }else{
                return new CreateQuizResponseDTO("null", 0);
            }
        }catch (Exception e){
            return new CreateQuizResponseDTO("error", 0);
        }
    }
}
