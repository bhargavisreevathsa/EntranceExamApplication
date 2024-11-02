package com.example.exam_service.Model;

import lombok.Data;

import java.util.List;

@Data
public class QuestionWrapper {
    private Integer qid;
    private QuestionType questionType;
    private String questionTitle;
    private List<String> options;

}
