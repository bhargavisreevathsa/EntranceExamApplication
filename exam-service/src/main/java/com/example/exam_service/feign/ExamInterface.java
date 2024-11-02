package com.example.exam_service.feign;

import com.example.exam_service.Model.QuestionWrapper;
import com.example.exam_service.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface ExamInterface {
    @GetMapping("questions/generate")
    ResponseEntity<List<Integer>> getQuestionsForExam(@RequestParam String type,
                                                             @RequestParam Integer numberOfQuestions);
    @PostMapping("questions/getQuestions")
    ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("questions/getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
