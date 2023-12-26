package com.example.globifyp;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world")String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestParam(value = "name", defaultValue = "world")String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }



}
