package com.example.question_service.dao;

import com.example.question_service.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends MongoRepository<Question, String> {
    @Query("{ 'question': ?0 }") // Query to find by question
    Question findByQuestion(String question);

    @Query("{'qid': ?0}")
    Question findByQid(Integer qid);

    @Query("{'questionType': ?0}")
    List<Question> findByType(String type);
}
