package com.darpan.quizzapp.service;

import com.darpan.quizzapp.dao.QuestionDao;
import com.darpan.quizzapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.getQuestionByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public String deleteQuestion(Question question) {
        questionDao.delete(question);
        return "success";
    }

    public String updateQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }
}
