package com.example.exam_service.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questionnaire")
public class Questionnaire {

    @Id
    String id;

    private Integer qid;
    private QuestionType questionType;
    private String question;
    private List<String> answers;

    private List<String> options;
    private Integer score;

    // Default constructor
    public Questionnaire(){}

    public Questionnaire(Integer qid, QuestionType questionType, String question,List<String> options, List<String> answers, Integer score) {
        this.qid = qid;
        this.questionType = questionType;
        this.question = question;
        this.options = options;
        this.answers = answers;
        this.score = score;
    }

    //Getters & Setters

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answersList) {
        answers = answersList;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }
}
