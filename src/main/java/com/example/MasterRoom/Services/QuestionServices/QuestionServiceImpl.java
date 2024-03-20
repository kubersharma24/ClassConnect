package com.example.MasterRoom.Services.QuestionServices;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO.ListOfQuestionRequestDTO;
import com.example.MasterRoom.Model.Dtos.RequestDTOs.QuestionRequestDTO.QuestionRequestDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.CreateQuestionResponseDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTO.QuizResponseDTO;
import com.example.MasterRoom.Model.Entitys.Questions;
import com.example.MasterRoom.Model.Entitys.Quiz;
import com.example.MasterRoom.Repositories.QuestionsRepository.QuestionsRepository;
import com.example.MasterRoom.Repositories.QuizRepository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionsRepository questionsRepositor;
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public CreateQuestionResponseDTO addQuestionsToQuiz(ListOfQuestionRequestDTO request) {
            if(quizRepository.existsById(request.getQuizId())){
                Quiz quiz = quizRepository.findAllById(request.getQuizId());
                if(quiz.getQuestions().size()!=0){
                    return new CreateQuestionResponseDTO("Quiz already have questions ");
                }
                List<QuestionRequestDTO> questionsReq = request.getQuestions();
                for(QuestionRequestDTO tempq : questionsReq){
                    Questions questions = new Questions();
                    questions.setQuestion(tempq.getQuestion());
                    questions.setOption1(tempq.getOption1());
                    questions.setOption2(tempq.getOption2());
                    questions.setOption3(tempq.getOption3());
                    questions.setOption4(tempq.getOption4());
                    questions.setAnswer(tempq.getAnswer());
                    quiz.getQuestions().add(questions);
                }
                quizRepository.save(quiz);
                return new CreateQuestionResponseDTO("Questions Atteched");
            }

            return new CreateQuestionResponseDTO("QuizNotFound");
    }


}
