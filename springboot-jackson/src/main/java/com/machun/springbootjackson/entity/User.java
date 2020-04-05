package com.machun.springbootjackson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author machun1
 */
public class User {

    private  String userName;
    @JsonIgnore
    private  String passWord;
    private  int age;
    @JsonProperty("性别")
    private  boolean sex;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date birthday;

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
        passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String userName, String passWord, int age, boolean sex, Date birthday) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", PassWord='" + passWord + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
