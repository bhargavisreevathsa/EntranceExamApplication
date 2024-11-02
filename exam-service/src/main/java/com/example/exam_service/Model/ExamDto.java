package com.example.exam_service.Model;

import lombok.Data;

@Data
public class ExamDto {
    String type;
    Integer numberOfQuestions;
    String title;
    Integer eid;

}
