package com.machun.springbootmybatisannotation.mapper;

import com.machun.springbootmybatisannotation.mapper.master.UserDao;
import com.machun.springbootmybatisannotation.mapper.salve.UserDaoSalve;
import com.machun.springbootmybatisannotation.entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 14:55
 * @UpdateDate: 2020/3/29 14:55
 * @menu
 */
@SpringBootTest
class UserDaoTest {
    public  static  long start;
    public  static long end;

    @Resource
    private UserDao userDao;
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
    void queryUserAll() {

        System.out.println("queryUserAll Test:");
        System.out.println( userDao.queryUserAll());
    }


    @Test
    void queryUserAllWithFilterMaster() {
        System.out.println("queryUserAll Master Test:");
        UserQueryPO userQueryPO=new UserQueryPO();
        userQueryPO.setUsername("liming");
        userQueryPO.setCurrentPage(0);
        userQueryPO.setPageSize(4);
        List<User> users=userDao.queryUserList(userQueryPO);
        System.out.println(users);

    }


    @Test
    void queryUserAllWithFilterSalve() {
        System.out.println("queryUserAll Salve Test:");
        UserQueryPO userQueryPO=new UserQueryPO();
        userQueryPO.setUsername("liming");
        userQueryPO.setCurrentPage(0);
        userQueryPO.setPageSize(4);
        List<User> users=userDaoSalve.queryUserList(userQueryPO);
        System.out.println(users);

    }
}