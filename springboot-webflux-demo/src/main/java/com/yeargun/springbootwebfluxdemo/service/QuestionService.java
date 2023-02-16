package com.yeargun.springbootwebfluxdemo.service;

import com.yeargun.springbootwebfluxdemo.dao.QuestionDao;
import com.yeargun.springbootwebfluxdemo.dto.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao dao;

    public List<Question> loadAllQuestions(){
        long start = System.currentTimeMillis();
        List<Question> questions = dao.getQuestions();
        long end = System.currentTimeMillis();
        System.out.println("Total exec time:" + (end-start));
        return questions;
    }

    public Flux<Question> loadAllQuestionsStream(){
        long start = System.currentTimeMillis();

        Flux<Question> questions = dao.getQuestonsStream();
        long end = System.currentTimeMillis();
        System.out.println("Total exec time:" + (end-start));
        return questions;
    }
}
