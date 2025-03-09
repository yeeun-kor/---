package com.spring.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/home/main")
    @ResponseBody
    public String home() {
        return "어서오세용 ";
    }
    @GetMapping("/home/plus")
    @ResponseBody
    //파라미터의 이름과 값이 일치해야함
    //plus?a=1&b=10
    //이라고 할때, a가 파라미터값이고, 1이 value값
    //스프링부트가 정해놓은 규칙임

    public int  plus1(  int a,  int b) {
        return a+b;
    }
    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean homeBoolean() {
        return true;
    }
    @GetMapping("/home/returnDouble")
    @ResponseBody
    public double homeBDouble() {
        return Math.PI;
    }
    @GetMapping("/home/returnList")
    @ResponseBody
    public List<Integer> homeList() {
        List<Integer> list = new ArrayList<>(){{add(10);add(30);add(40);}};

        return list;
    }


}
