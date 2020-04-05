package com.machun.springbootmongodb.repository;

import com.machun.springbootmongodb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/5 0:26
 * @UpdateDate: 2020/4/5 0:26
 * @menu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public  void  testSave(){

        User user=new User();
        user.setId(1);
        user.setUserName("小明"+1);
        user.setPassWord("让微软1234");
        userRepository.save(user);
    }


    @Test
    public void findUserByUserName(){
        User user= userRepository.findByUserName("小明1");
        System.out.println("user is "+user.toString());
    }


    @Test
    public void findAll(){
        List<User> user= userRepository.findAll();
        System.out.println("user is "+user.toString());
    }
}