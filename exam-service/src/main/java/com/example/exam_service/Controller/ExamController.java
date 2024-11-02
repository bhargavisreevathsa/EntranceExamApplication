package com.example.exam_service.Controller;

import com.example.exam_service.Model.ExamDto;
import com.example.exam_service.Model.QuestionWrapper;
import com.example.exam_service.Model.Response;
import com.example.exam_service.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("exam")
public class ExamController {
    @Autowired
    ExamService examService;
    @PostMapping("create")
    public ResponseEntity<String> createExam(@RequestBody ExamDto examDto) {
        return examService.createExam(examDto.getType(), examDto.getNumberOfQuestions(), examDto.getTitle(), examDto.getEid());
    }

    @GetMapping("get/{eid}")
    public ResponseEntity<List<QuestionWrapper>> getExamQuestions(@PathVariable Integer eid){
        return examService.getExamQuestions(eid);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitExam(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return examService.calculateResult(id, responses);
    }

}
