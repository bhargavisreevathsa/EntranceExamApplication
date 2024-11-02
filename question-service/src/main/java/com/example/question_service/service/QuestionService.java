package com.example.question_service.service;

import com.example.question_service.dao.CustomQuestionDaoImplementation;
import com.example.question_service.dao.QuestionDao;
import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;
import com.example.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    @Autowired
    CustomQuestionDaoImplementation customQDaoImpl;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByType(String type) {
        try {
            return new ResponseEntity<>(questionDao.findByType(type),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForExam(String type, Integer numberOfQuestions) {
        List<Integer> questionIds = customQDaoImpl.findRandomQuestionsByType(type, numberOfQuestions);
        return new ResponseEntity<>(questionIds, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer id : questionIds){
            questions.add(questionDao.findByQid(id));
        }


        for(Question question: questions){
           System.out.println(question.toString());
           QuestionWrapper wrapper = new QuestionWrapper();
           wrapper.setQid(question.getQid());
           wrapper.setQuestionTitle(question.getQuestionTitle());
           wrapper.setQuestionType(question.getQuestionType());
           wrapper.setOptions(question.getOptions());
           wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int score = 0;
        for(Response response: responses){
            Question question = questionDao.findByQid(response.getId());
            if(response.getResponse().equals(question.getAnswer())){
                score += question.getScore();
            }
        }
        return new ResponseEntity<>(score, HttpStatus.OK);

    }
}
