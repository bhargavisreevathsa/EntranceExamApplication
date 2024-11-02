package com.example.exam_service.Service;

import com.example.exam_service.Dao.ExamDao;
import com.example.exam_service.Model.Exam;
import com.example.exam_service.Model.QuestionWrapper;
import com.example.exam_service.Model.Response;
import com.example.exam_service.feign.ExamInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamService {
    @Autowired
    ExamDao examDao;

    @Autowired
    ExamInterface examInterface;

    public ResponseEntity<String> createExam(String type,int numQ,String title, Integer eid) {
        List<Integer> questions = examInterface.getQuestionsForExam(type, numQ).getBody();
        Exam exam = new Exam();
        exam.setTitle(title);
        exam.setEid(eid);
        exam.setQuestionIds(questions);
        examDao.save(exam);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getExamQuestions(Integer eid) {
        Exam exam = examDao.findByEid(eid);
        List<Integer> qids = exam.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = examInterface.getQuestionFromId(qids);
        List<QuestionWrapper> objects = questions.getBody();

        // Now you can work with the list of objects
        for (QuestionWrapper obj : objects) {
            // Process each object as needed
            System.out.println(obj);
        }
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = examInterface.getScore(responses);
        return score;
    }
}
