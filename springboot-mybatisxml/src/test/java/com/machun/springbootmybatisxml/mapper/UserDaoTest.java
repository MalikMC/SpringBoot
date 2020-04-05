package com.machun.springbootmybatisxml.mapper;

import com.machun.springbootmybatisxml.entity.Page;
import com.machun.springbootmybatisxml.entity.User;
import com.machun.springbootmybatisxml.entity.UserQueryPO;
import com.machun.springbootmybatisxml.enums.UserSexEnum;
import com.machun.springbootmybatisxml.mapper.salve.UserDaoSalve;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/28 22:15
 * @UpdateDate: 2020/3/28 22:15
 * @menu
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserDaoTest {

    public  static  long start;
    public  static long end;

    @Resource
    private  UserDao userDao;
    @Resource
    private UserDaoSalve userDaoSalve;
    @BeforeEach
    void setUp() {
        start=System.currentTimeMillis();
    }

    @AfterEach
    void tearDown() {
        end=System.currentTimeMillis();
        System.out.println("执行耗时："+(end-start)+"ms");
    }

    @Test
    void queryUserById() {
        System.out.println("queryUserById Test:");
      System.out.println( userDao.queryUserById("f55b7d3a352a4f0782c910b2c70f1ea4"));

    }

    @Test
    void queryUserAll() {

        System.out.println("queryUserAll Test:");
        System.out.println( userDao.queryUserAll());
    }

    @Test
    void insertUser(){
        System.out.println("新增User 测试");
        User user=new User();

        user.setUid(UUID.randomUUID().toString());
        user.setUsername("liming");
        user.setPassword("156213");
        user.setName("Ming");
        user.setEmail("232424@w4w4.com");
        user.setSex(UserSexEnum.MAN.toString());
        user.setBirthday (new Date());
        userDao.insertUser(user);
    }

    @Test
    void queryUserAllWithFilter() {
        System.out.println("queryUserAll Master Test:");
        UserQueryPO userQueryPO=new UserQueryPO();
        userQueryPO.setUserName("liming");
        userQueryPO.setCurrentPage(0);
        userQueryPO.setPageSize(4);
        List<User> users=userDao.queryUserList(userQueryPO);
        long count=userDao.getCount(userQueryPO);
        Page page = new Page(userQueryPO.getCurrentPage(),count/userQueryPO.getPageSize(),count,users);
        System.out.println(page);

    }


    @Test
    void queryUserAllWithFilterSalve() {
        System.out.println("queryUserAll Salve Test:");
        UserQueryPO userQueryPO=new UserQueryPO();
        userQueryPO.setUserName("liming");
        userQueryPO.setCurrentPage(0);
        userQueryPO.setPageSize(4);
        List<User> users=userDaoSalve.queryUserList(userQueryPO);
        long count=userDaoSalve.getCount(userQueryPO);
        Page page = new Page(userQueryPO.getCurrentPage(),count/userQueryPO.getPageSize(),count,users);
        System.out.println(page);

    }


}