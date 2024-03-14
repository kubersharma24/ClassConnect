package com.example.MasterRoom.Model.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="classroom")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClassRoom {
    @Id
    @Column(name = "classid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classcode")
    private String classCode;

    @ManyToOne(cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                                CascadeType.PERSIST,
                                CascadeType.REFRESH}) @JoinColumn(name = "Handlerid")
    private User handlerId;

    @Column(name = "classname")
    private String className;

    private String description;

    //    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    //    private List<Quiz> quiz;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_class_id")
   private List<Quiz> quiz;

    public List<Quiz> getQuiz() {
        return quiz;
    }

//    public void setQuiz(Quiz quizz) {
//        if(quiz == null){
//            quiz = new ArrayList<>();
//        }
//        quiz.add(quizz);
//    }
}

