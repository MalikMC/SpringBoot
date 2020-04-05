package com.machun.springbootelasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/5 16:54
 * @UpdateDate: 2020/4/5 16:54
 * @menu
 */
@Document(indexName = "customer", type = "doc", shards = 1, replicas = 0, refreshInterval = "-1")
public class Customer implements Serializable {
    @Id
    private String id;
    private String userName;
    private String address;
    private int age;

    public Customer() {
    }

    public Customer(String id, String userName, String address, int age) {
        this.id = id;
        this.userName = userName;
        this.address = address;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
