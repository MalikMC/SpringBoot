package com.machun.springbootthymeleaf.entity;

/**
 * @author machun1
 */
public class User {
    private  String userName;
    private  int age;
    private  String phone;
    private  String personUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonUrl() {
        return personUrl;
    }

    public void setPersonUrl(String personUrl) {
        this.personUrl = personUrl;
    }

    public User(String userName, int age, String phone, String personUrl) {
        this.userName = userName;
        this.age = age;
        this.phone = phone;
        this.personUrl = personUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", personUrl='" + personUrl + '\'' +
                '}';
    }
}
