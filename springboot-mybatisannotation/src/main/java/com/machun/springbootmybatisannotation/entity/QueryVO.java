package com.machun.springbootmybatisannotation.entity;

import java.util.List;

/**
 * @author machun1
 */
public class QueryVO {

    private List<String> ids;
    private User user;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
