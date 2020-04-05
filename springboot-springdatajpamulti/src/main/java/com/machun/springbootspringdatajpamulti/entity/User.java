package com.machun.springbootspringdatajpamulti.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/30 18:06
 * @UpdateDate: 2020/3/30 18:06
 * @menu
 */
@Entity
public class User implements Serializable {

    @Id
    @GenericGenerator(name = "system_id", strategy = "uuid")
    @GeneratedValue(generator = "system_id")
    private String uid;
    @Column(name = "username",nullable = false, unique = true)
    private String userName;
    @Column(name = "password",nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "nickname",nullable = true, unique = true)
    private String nickName;
    @Column(name = "regtime",nullable = false )
    private String regTime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }



    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }
}