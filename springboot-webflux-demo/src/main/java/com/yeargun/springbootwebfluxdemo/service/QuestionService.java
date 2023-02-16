package com.yeargun.springbootwebfluxdemo.service;

import com.yeargun.springbootwebfluxdemo.dto.QuestionDTO;
import com.yeargun.springbootwebfluxdemo.repository.QuestionRepository;
import com.yeargun.springbootwebfluxdemo.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    public Flux<QuestionDTO> getAllQuestions(){
        return repository.findAll().map(AppUtils::entityToDTO);
    }

    public Mono<QuestionDTO> getQuestion(String id){
        return repository.findById(id).map(AppUtils::entityToDTO);
    }



    public Mono<QuestionDTO> saveQuestion(Mono<QuestionDTO> questionDTOMono){
        System.out.println("saving question ...");
        return  questionDTOMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDTO);
    }

    public Mono<QuestionDTO> updateQuestion(Mono<QuestionDTO> questionDTOMono,String id){
        return repository.findById(id)
                .flatMap(p->questionDTOMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDTO);

    }

    public Mono<Void> deleteQuestion(String id){
        return repository.deleteById(id);
    }
}
