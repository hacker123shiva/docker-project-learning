package com.telusko.RestDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

    @RequestMapping("/")
    public String sayHi() {
        return "Hello World!";
    }

}