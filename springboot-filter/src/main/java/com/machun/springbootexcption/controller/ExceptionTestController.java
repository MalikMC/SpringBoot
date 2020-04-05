package com.machun.springbootexcption.controller;

import com.machun.springbootexcption.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author machun1
 */
@Controller
@RequestMapping("exc")
public class ExceptionTestController {

    @RequestMapping("getone")
    public User getUserInfo(){
          int m=10/0;
        return  new User("machun","1243532324",32,true,new Date());
    }




}
