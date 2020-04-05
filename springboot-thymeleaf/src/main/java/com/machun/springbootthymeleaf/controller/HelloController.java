package com.machun.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author machun1
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("sayhello")
    public  String SayHello(Model model){
        model.addAttribute("message","我是Thymeleaf");
        return "helloword";
    }
}
