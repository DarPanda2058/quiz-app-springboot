package com.darpan.quizzapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotNull
    @Size(min = 1, max = 255)
    private String question;
    @NotNull
    @Size(min = 1, max = 255)
    private String firstAns;
    @NotNull
    @Size(min = 1, max = 255)
    private String secondAns;
    @NotNull
    @Size(min = 1, max = 255)
    private String thirdAns;
    @NotNull
    @Size(min = 1, max = 255)
    private String fourthAns;
    @NotNull
    @Size(min = 1, max = 255)
    private String category;
    @NotNull
    @Size(min = 1, max = 255)
    private String rightAns;

}
