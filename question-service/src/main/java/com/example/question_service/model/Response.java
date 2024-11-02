package com.example.question_service.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Response {
    private Integer id;
    private String response;
}
