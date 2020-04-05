package com.machun.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/28 14:39
 * @UpdateDate: 2020/3/28 14:39
 * @menu
 */
@Data
@TableName(value = "user")
public class User implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String uid;
    private String username;
    private  String password;
    private String name;
    private String email;
    private String telephone;
    private Date birthday;
    private String sex;
    private  int state;
    private  String code;

}
