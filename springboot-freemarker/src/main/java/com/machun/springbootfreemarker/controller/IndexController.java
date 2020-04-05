package com.machun.springbootfreemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author machun1
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("hello")
    public String  Hello(ModelMap map){
        map.addAttribute("name","MaChun");
       return  "default";
    }

}
