package com.machun.springbootjdbc.repository;

import com.machun.springbootjdbc.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.SynchronousQueue;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/28 15:59
 * @UpdateDate: 2020/3/28 15:59
 * @menu
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private JdbcTemplate masterJdbcTemplate;
    @Autowired
    private JdbcTemplate salveJdbcTemplate;


    long start;
    long end;
    @BeforeEach
    void setUp() {
        System.out.println("测试用户方法开始："+System.currentTimeMillis());
        start= System.currentTimeMillis();
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试用户方法结束："+System.currentTimeMillis());
         end= System.currentTimeMillis();
        System.out.println("执行时间："+(end-start) + "ms");

    }

    @Test
    void save() {
        System.out.println("测试用户保存方法："+System.currentTimeMillis());
        User user= new User(UUID.randomUUID().toString(),"machun","1243545","Chun","3242324@qq.com","14663823243",new Date(),"男",3,"Successfully");
        userRepository.save(user,  masterJdbcTemplate);
    }

    @Test
    void update() {



        System.out.println("测试用户更新方法："+System.currentTimeMillis());
        User user= new User("c95b15a864334adab3d5bb6604c6e1fc","machun","1243545","Chun","3242324@qq.com","14663823243",new Date(),"男",3,"Successfully");
        userRepository.update(user,masterJdbcTemplate);
        System.out.println("c95b15a864334adab3d5bb6604c6e1fc----己更新" );
    }

    @Test
    void delete() {
        System.out.println("测试用户删除方法："+System.currentTimeMillis());
        userRepository.delete("827d98e6-ac81-452f-a5ee-31f05fbb3734",masterJdbcTemplate);
        System.out.println("827d98e6-ac81-452f-a5ee-31f05fbb3734 ----己删除" );
    }

    @Test
    void findALL() {
        System.out.println("测试查找所有用户方法："+System.currentTimeMillis());
       List<User> userList=  userRepository.findALL(salveJdbcTemplate);
       System.out.println(userList);
    }

    @Test
    void findById() {
        System.out.println("测试根据ID查找用户方法："+System.currentTimeMillis());
        System.out.println( userRepository.findById("ee49e140-1c1b-4f5c-8a07-e95318b41d62",salveJdbcTemplate));
    }
}