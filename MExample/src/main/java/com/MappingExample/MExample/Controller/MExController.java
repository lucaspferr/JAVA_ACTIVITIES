package com.MappingExample.MExample.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MExController {

    @GetMapping("/t1")
    public String test1(){
        return "Hello World!";
    }

    @GetMapping("/t2")
    public String test2(){
        String b="";
        for(int a=0;a<=10;a++){
            if(a==0) b=b+a;
            else b=b+"-"+a;
        }
        return b;
    }
    @GetMapping("/t3")
    public String ExtAPI(){
        String uri = "https://jsonplaceholder.typicode.com/todos/1";
        RestTemplate exta = new RestTemplate();
        String result = exta.getForObject(uri, String.class);
        return result;
    }
}
