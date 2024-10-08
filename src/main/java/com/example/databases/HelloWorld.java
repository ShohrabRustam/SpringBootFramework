package com.example.databases;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld
{
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!, Welcome to learn new framework Spring Boot";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hello! "+ name;
    }
}
