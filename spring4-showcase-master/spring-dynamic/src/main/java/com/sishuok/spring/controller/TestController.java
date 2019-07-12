package com.sishuok.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/aaa")
    @ResponseBody
    public String aaa(){
        return "aaa";
    }
}
