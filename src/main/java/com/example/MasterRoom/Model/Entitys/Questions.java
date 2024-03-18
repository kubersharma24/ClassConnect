package com.example.MasterRoom.Model.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="question")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Questions {
    @Id
    @Column(name = "questionid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

}
