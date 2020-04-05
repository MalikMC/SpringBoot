package com.machun.springbootmybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.machun.springbootmybatisplus.entity.User;
import com.machun.springbootmybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 21:17
 * @UpdateDate: 2020/3/29 21:17
 * @menu
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    public String sayHello() {

        return "Hello World!";
    }


    @PostMapping("getInfo/{userId}")
    public User getInfo(@PathVariable String userId) {
        User User = userService.getById(userId);
        return User;
    }


    @RequestMapping("getuserlist")
    public String getUserList() {
        List<User> list = userService.list();
        System.out.println("list:" + list);
        return list.toString();
    }

    @PostMapping("getInfoListPage")
    public IPage<User> getInfoListPage() {
        //需要在Config配置类中配置分页插件
        IPage<User> page = new Page<>();
        //当前页
        page.setCurrent(0);
        //每页条数
        page.setSize(2);
        page = userService.page(page);
        return page;
    }


    @RequestMapping("insert")
    public String insert() {
        User user = new User();
        user.setUsername("wanghonghong");
        user.setPassword("1t356357456");
        user.setName("Hong");
        user.setBirthday(new Date());
        user.setSex("女");
        boolean save = userService.save(user);
        return getUserList();
    }

    @PostMapping("updateInfo")
    public void updateInfo() {
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        User User = new User();
        User.setUid("556fea473c5140310a07cedfae62df18");
        User.setEmail("1243534534@qq.com");
        User.setTelephone("12435345342434");
        userService.updateById(User);
    }


    @PostMapping("saveOrUpdateInfo")
    public void saveOrUpdate() {
        //传入的实体类User中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        User User = new User();
        User.setUsername("AiDiLuo");
        User.setEmail("1243534534@qq.com");
        User.setTelephone("12435345342434");
        userService.saveOrUpdate(User);
    }

    @PostMapping("deleteInfo")
    public void deleteInfo(String userId) {
        userService.removeById(userId);
    }

    @PostMapping("deleteInfoMap")
    public void deleteInfoMap() {
        //kay是字段名 value是字段值
        Map<String, Object> map = new HashMap<>();
        map.put("username", "machun");
        map.put("password", "1243545");
        userService.removeByMap(map);

    }


    @RequestMapping("/getInfoListPlus")
    public Map<String, Object> getInfoListQueryWrapper() {
        //初始化返回类
        Map<String, Object> result = new HashMap<>();

     /*   QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(User::getState,0);
        List<User> UserList1 = userService.list(queryWrapper1);
        result.put("userCode0",UserList1);

        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.lambda().gt(User::getBirthday,"2010-2-1");
        queryWrapper2.lambda().le(User::getBirthday,"2020-3-1");
        List<User> UserList2 = userService.list(queryWrapper2);
        result.put("userBirthday",UserList2);

     QueryWrapper<User> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.lambda().like(User::getName,"ming");
        queryWrapper3.lambda().orderByDesc(User::getBirthday);
        List<User> UserList3 = userService.list(queryWrapper3);
        result.put("userorderby",UserList3);

           QueryWrapper<User> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.lambda().like(User::getName,"小");
        queryWrapper4.lambda().or().gt(User::getSex,"女");
        List<User> UserList4 = userService.list(queryWrapper4);
        result.put("userOr",UserList4);*/

        IPage<User> page = new Page<>();
        page.setCurrent(0);
        page.setSize(5);
        QueryWrapper<User> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.lambda().isNotNull(User::getBirthday);
        page = userService.page(page, queryWrapper5);
        result.put("userPhonenotnull", page);
        return result;
    }


}