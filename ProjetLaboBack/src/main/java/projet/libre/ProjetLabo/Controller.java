package com.example.demo;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class Controller {


   @GetMapping("/getMessage")
    public String Hello() {
        return "Hello from the back";


    }

}
