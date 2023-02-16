package com.yeargun.springbootwebfluxdemo.repository;

import com.yeargun.springbootwebfluxdemo.dto.QuestionDTO;
import com.yeargun.springbootwebfluxdemo.entity.Question;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String>{

}
