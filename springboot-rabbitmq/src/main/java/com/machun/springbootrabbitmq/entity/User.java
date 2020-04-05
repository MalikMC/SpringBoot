package com.machun.springbootrabbitmq.entity;

import java.io.Serializable;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/4 20:33
 * @UpdateDate: 2020/4/4 20:33
 * @menu
 */
public class User implements Serializable {
private  String userName;
private  String sex;
private  int age;

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

    public User(String userName, String sex, int age) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

}
