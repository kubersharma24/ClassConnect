package com.example.MasterRoom.Model.Entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name ="quiz")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Quiz {

    @Id
    @Column(name = "quizid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_classid")
//    private ClassRoom classRoom;

    @Column(name = "Quizname")
    private String QuizName;

    private String description;
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_quiz_id")
    private List<Questions> questions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_quiz_id")
    private List<Score> score;

}
