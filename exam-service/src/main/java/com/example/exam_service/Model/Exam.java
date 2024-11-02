package com.example.exam_service.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection="exam")
public class Exam {
    @Id
    String id;
    Integer eid;
    String title;
    List<Integer> questionIds;

}
