package com.machun.springbootjdbc.repository.impl;

import com.machun.springbootjdbc.entity.User;
import com.machun.springbootjdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/28 15:01
 * @UpdateDate: 2020/3/28 15:01
 * @menu
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate masterJdbcTemplate;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public int save(User user , JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null){
            jdbcTemplate= masterJdbcTemplate;
        }
        return jdbcTemplate.update("INSERT INTO  user(`uid`, `username`,`password`,`name`,`email`,`telephone`,`birthday`,`sex`,`state`,`code`) VALUES(?,?,?,?,?,?,?,?,?,?)",
                user.getUid(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getTelephone(),
                user.getBirthday(),
                user.getSex(),
                user.getState(),
                user.getCode()
        );

    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user , JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null){
            jdbcTemplate= masterJdbcTemplate;
        }
        System.out.printf(user.toString());
       return  jdbcTemplate.update("UPDATE `user` SET `username` = ?,`password` = ?,`name` =? ,`email` = ?,`telephone` =?,`birthday` = ?,`sex` = ?,`state` = ?,`code` =? where `uid` = ?",
               user.getUsername(),
               user.getPassword(),
               user.getName(),
               user.getEmail(),
               user.getTelephone(),
               user.getBirthday(),
               user.getSex(),
               user.getState(),
               user.getCode(),
               user.getUid()
               );

    }

    /**
     * 删除用户
     *
     * @param uid
     * @returnu
     */
    @Override
    public int delete(String uid, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null){
            jdbcTemplate= masterJdbcTemplate;
        }
        return jdbcTemplate.update("DELETE FROM user where uid = ? ",uid);
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @Override
    public List<User> findALL(JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null){
            jdbcTemplate= masterJdbcTemplate;
        }
        return jdbcTemplate.query("SELECT * FROM user", new UserRowMapper());
    }

    /**
     * 根据用户ID查找用户
     *
     * @param uid
     * @return
     */
    @Override
    public User findById(String uid, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null){
            jdbcTemplate= masterJdbcTemplate;
        }
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE uid=?", new Object[] { uid }, new BeanPropertyRowMapper<User>(User.class));
    }

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUid(rs.getString("uid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setBirthday(rs.getDate("birthday"));
            user.setSex(rs.getString("sex"));
            user.setState(rs.getInt("state"));
            user.setCode(rs.getString("code"));
            return user;
        }
    }

}

