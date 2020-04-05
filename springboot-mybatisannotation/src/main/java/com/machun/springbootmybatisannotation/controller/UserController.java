package com.machun.springbootmybatisannotation.controller;

import com.machun.springbootmybatisannotation.mapper.master.UserDao;
import com.machun.springbootmybatisannotation.mapper.salve.UserDaoSalve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/1 19:45
 * @UpdateDate: 2020/4/1 19:45
 * @menu
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserDao userDao;
    @Resource
    private UserDaoSalve userDaoSalve;

    @RequestMapping("getuser")
    public  Object getUser(ModelMap map){
        map.put("Master",userDao.queryUserAll());
        map.put("Salve",userDaoSalve.queryUserAll());
        return map.getAttribute("Master");
    }
}
