package com.yeargun.springbootwebfluxdemo.controller;


import com.yeargun.springbootwebfluxdemo.dto.Question;
import com.yeargun.springbootwebfluxdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("/")
    public List<Question> getAllQuestions() {
        return service.loadAllQuestions();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Question> getAllQuestionsStraem() {
        return service.loadAllQuestionsStream();
    }

}
