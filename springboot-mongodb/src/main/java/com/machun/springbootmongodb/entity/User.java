package com.machun.springbootmongodb.entity;

import com.machun.springbootmongodb.repository.UserRepository;

import javax.swing.*;
import java.io.Serializable;
import java.rmi.server.UID;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/5 0:14
 * @UpdateDate: 2020/4/5 0:14
 * @menu
 */
public class User implements Serializable {

    private  static  long serialVersionUid=-153564232431231213L;

    private  long id;
    private String userName;
    private  String passWord;

    public User(){}
    public User(long id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
