package com.machun.springbootswagger.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * @author machun1
 * @menu User相关操作
 */

@RestController
@RequestMapping("user")
@Api(value ="用户相关操作", description = "用户相关操作 API" )
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
     @ApiOperation(value="用户登录")
     @ApiImplicitParams({
             @ApiImplicitParam(name = "userName", value = "用户ID", required = true, dataType = "String", paramType = "query"),
             @ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String", paramType = "query"),
     })
     @PostMapping("api/v1.0/login/{userName}/{passWord}")
    public String login(@PathVariable("userName") String userName, @PathVariable("passWord") String passWord) {
        return  "login Successfully";
    }

    @ApiOperation(value="根据用户ID查找用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("api/v1.0/findUserById/{userId}")
    public String  findUserById(@PathVariable("userId") String userId) {
        return  "User："+userId;
    }
}
