package com.example.MasterRoom.Services.QuizServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.CreateQuizRequest.CreateQuizResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetAllQuizReponse.QuizResponse;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId.GetClassRoomWithHandlerIdResponseDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuizStatus.QuizStatusRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuizStatus.QuizStatusResponse;
import com.example.MasterRoom.Model.Entitys.ClassRoom;
import com.example.MasterRoom.Model.Entitys.Quiz;
import com.example.MasterRoom.Model.Entitys.User;
import com.example.MasterRoom.Repositories.ClassRepository.ClassRepository;
import com.example.MasterRoom.Repositories.QuizRepository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<QuizResponse> getAllTheQuizInClass(String classRoomCode, int page, int size) {
        if (classRepository.existsByClassCode(classRoomCode)) {
            ClassRoom classRoom = classRepository.findByClassCode(classRoomCode);
            List<Quiz> allQuizzes = classRoom.getQuiz();

            // Calculate start and end indices for pagination
            int startIndex = page * size;
            int endIndex = Math.min(startIndex + size, allQuizzes.size());

            // Get sublist for the current page
            List<Quiz> quizzesForPage = allQuizzes.subList(startIndex, endIndex);

            // Convert quizzes to QuizResponse DTOs
            List<QuizResponse> response = quizzesForPage.stream()
                    .map(this::mapToQuizResponse)
                    .collect(Collectors.toList());

            return response;
        } else {
            return null;
        }
    }

    @Override
    public QuizStatusResponse setQuizStatus(QuizStatusRequestDTO request) {
        if(quizRepository.existsById(request.getQuizId())){
            Quiz quiz = quizRepository.findAllById(request.getQuizId());
            if(quiz.getStatus().equals("on"))
                quiz.setStatus("off");
            else
                quiz.setStatus("on");
            quizRepository.save(quiz);
            return new QuizStatusResponse("changed");
        }
        return new QuizStatusResponse("Quiz Not Found");
    }

    private QuizResponse mapToQuizResponse(Quiz quiz) {
        QuizResponse response = new QuizResponse();
        response.setId(quiz.getId());
        response.setQuizName(quiz.getQuizName());
        response.setDescription(quiz.getDescription());
        response.setStatus(quiz.getStatus());
        return response;
    }
}
