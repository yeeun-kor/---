package com.spring.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @GetMapping("/services")
    public String sayHello() {
        return "Member list is 라이브 리로드 언제쯤 리로드 되려나 ";
    }
    @GetMapping("/services/main")
    public String sayHello2() {
        return "Hello, Spring Boot22222222!";
    }
    @GetMapping("/services/home")
    @ResponseBody
    public String sayHello3() {
        return "Hello, Spring Boot!333333333 3번이구요";
    }

    @GetMapping("hello-mvc")

    public String helloMvc(String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

}
