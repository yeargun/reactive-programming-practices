package com.yeargun.springbootwebfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){

//        Publisher
        Mono<?> monoString = Mono.just("yeargun")
                .then(Mono.error(new RuntimeException("Exception occurred")))
                .log();
//        Subscriber
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }


    public void testFlux(){
        Flux<String> fluxString = Flux.just("hello", "reactive", "shut")
                .concatWithValues("yeargun")
                .concatWith(Flux.error(new RuntimeException("XD")))
                .concatWithValues("cloud")
                .log();

    }
}
