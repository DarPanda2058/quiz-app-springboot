package com.darpan.quizzapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String question;
    private String firstAns;
    private String secondAns;
    private String thirdAns;
    private String fourthAns;
    private String category;
    private String rightAns;

}
