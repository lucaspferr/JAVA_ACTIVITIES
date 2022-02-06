package com.lucas.trad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tradutor")
public class APIController {

    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
