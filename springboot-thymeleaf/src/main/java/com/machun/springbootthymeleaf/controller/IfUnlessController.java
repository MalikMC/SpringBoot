package com.machun.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author machun1
 */
@Controller
@RequestMapping("ifu")
public class IfUnlessController {

    @RequestMapping("show")
    public String ifUnless(Model model){
        model.addAttribute("sex","1");
        model.addAttribute("woman","我是女生");
        model.addAttribute("man","我是男生");

        return "ifunless";
    }
}
