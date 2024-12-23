package com.darpan.quizzapp.service;

import com.darpan.quizzapp.dao.QuestionDao;
import com.darpan.quizzapp.dao.QuizDao;
import com.darpan.quizzapp.model.Question;
import com.darpan.quizzapp.model.QuestionWrapper;
import com.darpan.quizzapp.model.Quiz;
import com.darpan.quizzapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizDao quizDao;
    private final QuestionDao questionDao;

    public QuizService(QuizDao quizDao, QuestionDao questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }


    public ResponseEntity<String> createQuiz(String category, int numQ, String quizTitle) {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(quizTitle);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for (Question question:questionsFromDB){
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getID(),question.getQuestion(),question.getFirstAns(),question.getSecondAns(),question.getThirdAns(),question.getFourthAns());
            questionForUser.add(questionWrapper);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        Integer result = 0;
        int i =0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAns())){
                result++;

            }
            i++;
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
