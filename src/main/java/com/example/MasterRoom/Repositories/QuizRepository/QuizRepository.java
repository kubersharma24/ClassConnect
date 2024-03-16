package com.example.MasterRoom.Repositories.QuizRepository;

import com.example.MasterRoom.Model.Entitys.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findAllById(long id);
}
