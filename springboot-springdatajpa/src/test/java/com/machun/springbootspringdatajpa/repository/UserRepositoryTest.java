package com.machun.springbootspringdatajpa.repository;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/30 19:27
 * @UpdateDate: 2020/3/30 19:27
 * @menu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    public void testBaseQuery() {


        //region 基本查询
        /*userRepository.findAll();
        System.out.println(userRepository.findById("62145f6e66ea4f5cbe7b6f6b954917d3"));
        User user = new User();
        user.setUserName("AiDiLuo");
        user.setPassWord("124353452");
        user.setEmail("4tyk45k4@134.com");
        user.setNickName("AiDiLuo");
        user.setRegTime("2020-12-24");
        userRepository.save(user);
        //userRepository.delete(user);
        userRepository.count();
        userRepository.existsById("62145f6e66ea4f5cbe7b6f6b954917d3");*/
        //endregion

        //region 自定义查询
       /* System.out.println(userRepository.findByUserName("AiDiLuo"));
        System.out.println(userRepository.findByUserNameAndEmailContains("AiDiLuo", "134"));*/
        //endregion

        //region 自定义 SQL 查询
        int page = 0, size = 10;
        Pageable pageable = PageRequest.of(page, size);
        System.out.println(userRepository.findALL(pageable).getContent());
        // System.out.println(userRepository.findByNickName( "AiDiLuo"));
        //endregion

    }


}