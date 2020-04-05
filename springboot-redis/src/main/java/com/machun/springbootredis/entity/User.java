package com.machun.springbootredis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/2 11:25
 * @UpdateDate: 2020/4/2 11:25
 * @menu
 */
public class User implements Serializable {
    private  String userName;
    private String sex;
    private  int age;
    private Date birthDay;

    public User(String userName, String sex, int age, Date birthDay) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.birthDay = birthDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                '}';
    }
}
