package com.machun.springbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.machun.springbootmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 21:11
 * @UpdateDate: 2020/3/29 21:11
 * @menu
 */

public interface UserDao extends BaseMapper<User> {
}
