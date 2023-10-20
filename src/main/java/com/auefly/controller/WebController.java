package com.auefly.controller;

import com.auefly.pojo.Person;
import com.auefly.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    @Autowired
    private Pet pet;

    @GetMapping("/")
    String home(){
        return "Hello World!";
    }

    @GetMapping("/xml-and-json")
    Pet xmlAndJsonTest(){
        pet.setName("jerry");
        pet.setWeight(12.7);
        return pet;
    }

    @PostMapping("/save-person")
    @ResponseBody
    public Person savePerson(@RequestBody Person person){
        return person;
    }

    @PostMapping("/save-person1")
    @ResponseBody
    public Person savePerson1(Person person){
        return person;
    }

}