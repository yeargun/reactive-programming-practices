package com.yeargun.springbootwebfluxdemo.controller;


import com.yeargun.springbootwebfluxdemo.dto.QuestionDTO;
import com.yeargun.springbootwebfluxdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<QuestionDTO> getAllQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping
    public Mono<QuestionDTO> getQuestion(@PathVariable String id) {
        return service.getQuestion(id);
    }

    @PostMapping
    public Mono<QuestionDTO> saveProduct(@RequestBody Mono<QuestionDTO> questionDTOMono){
        System.out.println("saving question");
        return service.saveQuestion(questionDTOMono);
    }

    @PutMapping("/update/{id}")
    public Mono<QuestionDTO> updateProduct(@RequestBody Mono<QuestionDTO> questionDTOMono,@PathVariable String id){
        return service.updateQuestion(questionDTOMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteQuestion(@PathVariable String id){
        return service.deleteQuestion(id);
    }


}
