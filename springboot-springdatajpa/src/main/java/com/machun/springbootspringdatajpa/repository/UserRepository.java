package com.machun.springbootspringdatajpa.repository;

import com.machun.springbootspringdatajpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/30 19:23
 * @UpdateDate: 2020/3/30 19:23
 * @menu
 */
public interface UserRepository  extends JpaRepository<User,String> {
     User findByUserName(String username);
     User findByUserNameAndEmailContains(String username,String email);

     @Query("select u from User  u")
     Page<User> findALL(Pageable pageable);

     @Query(value = "select * from user u where u.nickname = ?1", nativeQuery = true)
      User findByNickName(String nickName);

}