package com.darpan.quizzapp.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class QuestionWrapper {
    private Integer ID;

    private String question;
    private String firstAns;
    private String secondAns;
    private String thirdAns;
    private String fourthAns;

    public QuestionWrapper(Integer ID, String question, String firstAns, String secondAns, String thirdAns, String fourthAns) {
        this.ID = ID;
        this.question = question;
        this.firstAns = firstAns;
        this.secondAns = secondAns;
        this.thirdAns = thirdAns;
        this.fourthAns = fourthAns;
    }
}
