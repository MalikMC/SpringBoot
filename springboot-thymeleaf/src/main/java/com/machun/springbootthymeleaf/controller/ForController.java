package com.machun.springbootthymeleaf.controller;

import com.machun.springbootthymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machun1
 */
@Controller
@RequestMapping("foreach")
public class ForController {



    @RequestMapping("userlist")
    public String getUserList(ModelMap map){
        List<User> list=new ArrayList<User>();
        User user1=new User("大牛",12,"7723123456","http://www.baidu.con");
        User user2=new User("小牛",6,"356123563","http://www.lenovo.com");
        User user3=new User("微笑",32,"11424666666","http://www.suho.com");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        map.addAttribute("users",list);
        return  "for";
    }
}
