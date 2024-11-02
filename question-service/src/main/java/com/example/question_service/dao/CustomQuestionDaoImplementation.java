package com.example.question_service.dao;

import com.example.question_service.model.QidDto;
import com.example.question_service.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomQuestionDaoImplementation implements CustomQuestionDao {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<Integer> findRandomQuestionsByType(String type, Integer numberOfQuestions) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("questionType").is(type)),
                Aggregation.sample(numberOfQuestions)
        );

        AggregationResults<QidDto> results = mongoTemplate.aggregate(aggregation, Question.class, QidDto.class);
        return results.getMappedResults().stream()
                .map(QidDto::getQid)
                .collect(Collectors.toList());

    }
}
