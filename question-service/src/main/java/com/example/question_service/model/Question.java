package com.example.question_service.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "questions")
public class Question {
    private Integer qid;
    private QuestionType questionType;
    private String questionTitle;
    private List<String> options;
    private String answer;
    private Integer score;
}
