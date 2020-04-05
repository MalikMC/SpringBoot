package com.machun.springbootexcption.controller;

import com.machun.springbootexcption.vo.ResponseJsonData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author machun1
 * @menu User相关操作
 */
@RestController
@RequestMapping("user")
public class UserController {


     /**
      * @description: 用户登录
      * @author: machun
      * @updateUser: machun
      * @param userName 用户名
      * @param passWord 密码
      * @return ResponseJsonData
      * @createDate: 2020/3/26 12:52
      * @updateDate: 2020/3/26 12:52
      * @version: V1.0
      * @status: undone
     */
     @RequestMapping("api/v1.0/login/{userName}/{passWord}")
    public ResponseJsonData login(@PathVariable("userName") String userName, @PathVariable("passWord") String passWord) {
        return  new ResponseJsonData("200","login Successfully",userName);
    }
}
