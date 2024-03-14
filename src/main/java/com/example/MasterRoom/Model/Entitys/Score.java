package com.example.MasterRoom.Model.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="score")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Score {
    @Id
    @Column(name = "scoreid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentid")
    private User Student;

    @Column(name="totalquestions")
    private int totalQuestion;

    @Column(name="correctanswers")
    private int correctAnswers;
}
