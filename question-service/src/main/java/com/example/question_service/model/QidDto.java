package com.example.question_service.model;

import lombok.Data;

@Data
public class QidDto {
    private Integer qid;

    public QidDto(Integer qid) {
        this.qid = qid;
    }
}
