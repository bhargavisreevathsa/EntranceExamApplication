package com.example.exam_service.Dao;

import com.example.exam_service.Model.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamDao extends MongoRepository<Exam, String> {

    @Query("{'eid': ?0}")
    Exam findByEid(Integer eid);
}
