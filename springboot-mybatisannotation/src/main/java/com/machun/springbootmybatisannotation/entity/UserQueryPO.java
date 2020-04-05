package com.machun.springbootmybatisannotation.entity;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 12:12
 * @UpdateDate: 2020/3/29 12:12
 * @menu
 */
public class UserQueryPO extends PageParam {

    private  String username;
    private  String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
