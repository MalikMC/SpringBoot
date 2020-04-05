package com.machun.springbootmongodb.repository;

import com.machun.springbootmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/5 0:23
 * @UpdateDate: 2020/4/5 0:23
 * @menu
 */
public interface UserRepository extends MongoRepository<User,Long> {
    User findByUserName(String userName);
}
