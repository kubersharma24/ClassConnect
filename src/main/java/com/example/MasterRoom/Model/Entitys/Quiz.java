package com.example.MasterRoom.Model.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name ="quiz")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Quiz {

    @Id
    @Column(name = "quizid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Quizname")
    private String QuizName;

    private String description;
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quizid")
    private List<Questions> questions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quizid")
    private List<Score> score;
}
