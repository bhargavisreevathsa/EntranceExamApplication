package com.example.question_service.dao;

import java.util.List;

public interface CustomQuestionDao {
    List<Integer> findRandomQuestionsByType(String type, Integer numberOfQuestions);
}
