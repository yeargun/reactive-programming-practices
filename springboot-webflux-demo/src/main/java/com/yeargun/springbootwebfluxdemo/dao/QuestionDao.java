package com.yeargun.springbootwebfluxdemo.dao;

import com.yeargun.springbootwebfluxdemo.dto.Question;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class QuestionDao {

    public static void sleepThread(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<Question> getQuestions(){
        return IntStream.rangeClosed(1,50)
                .peek(i-> System.out.println("processing count: " + i))
                .peek(QuestionDao::sleepThread)
                .mapToObj(i-> new Question(i,
                String.format("interestingQuestion: %s",String.valueOf(i)),
                Arrays.asList("A","B","C")
                ))
                .collect(Collectors.toList());
    }

    public Flux<Question> getQuestonsStream(){
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("proccessing count: "+ i))
                .map(i-> new Question(i,
                        String.format("interestingQuestion: %s",String.valueOf(i)),
                        Arrays.asList("A","B","C")
                ));
    }
}
