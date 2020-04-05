package com.machun.springbootjdbc.repository;
import com.machun.springbootjdbc.entity.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/28 14:48
 * @UpdateDate: 2020/3/28 14:48
 * @menu
 */
public interface UserRepository {

        /**
         * 添加用户
         * @param user
         * @return
         */
        int save(User user, JdbcTemplate jdbcTemplate);

        /**
         * 更新用户
         * @param user
         * @return
         */
        int update(User user, JdbcTemplate jdbcTemplate);

        /**
         * 删除用户
         * @param uid
         * @return
         */
        int delete(String uid, JdbcTemplate jdbcTemplate);

        /**
         * 查找所有用户
         * @return
         */
        List<User> findALL(JdbcTemplate jdbcTemplate);

        /**
         * 根据用户ID查找用户
         * @param uid
         * @return
         */
        User findById(String  uid, JdbcTemplate jdbcTemplate);

}
