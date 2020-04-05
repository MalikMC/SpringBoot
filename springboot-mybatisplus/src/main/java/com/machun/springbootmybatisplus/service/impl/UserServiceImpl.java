package com.machun.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.machun.springbootmybatisplus.dao.UserDao;
import com.machun.springbootmybatisplus.entity.User;
import com.machun.springbootmybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 21:15
 * @UpdateDate: 2020/3/29 21:15
 * @menu
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
