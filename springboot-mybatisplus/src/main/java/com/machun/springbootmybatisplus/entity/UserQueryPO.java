package com.machun.springbootmybatisplus.entity;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 12:12
 * @UpdateDate: 2020/3/29 12:12
 * @menu
 */
public class UserQueryPO extends PageParam {

    private  String userName;
    private  String sex;

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
}
