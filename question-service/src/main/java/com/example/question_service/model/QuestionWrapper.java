package com.example.question_service.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class QuestionWrapper {
    private Integer qid;
    private QuestionType questionType;
    private String questionTitle;
    private List<String> options;
}
