package com.machun.springbootjackson.controller;

import com.machun.springbootjackson.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;


/**
 * @author machun1
 */

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("getone")
    public User getUserInfo(){

        return  new User("machun","1243532324",32,true,new Date());
    }


    @RequestMapping("getall")
    public ArrayList<User> getAllUserInfo(){

        ArrayList<User> userList=new ArrayList<User>();
          userList.add(  new User("machun","1243532324",32,true,new Date()));
         userList.add(  new User("zhangming","1243532324",22,true,new Date()));
        userList.add(  new User("sda","1243532324",22,true,new Date()));
        userList.add(  new User("s3566da","1243532324",22,true,new Date()));
        userList.add(  new User("sWWWWda","1243532324",22,true,new Date()));
     System.out.println("hot loading14333");


        return userList  ;
    }

}


